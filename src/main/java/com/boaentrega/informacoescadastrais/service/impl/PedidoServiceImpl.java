package com.boaentrega.informacoescadastrais.service.impl;

import com.boaentrega.informacoescadastrais.client.ServicoCliente;
import com.boaentrega.informacoescadastrais.exception.BusinnesException;
import com.boaentrega.informacoescadastrais.model.Pedido;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;
import com.boaentrega.informacoescadastrais.model.dto.PedidoStatus;
import com.boaentrega.informacoescadastrais.model.factory.PedidoFactory;
import com.boaentrega.informacoescadastrais.repository.PedidoRepository;
import com.boaentrega.informacoescadastrais.service.PedidoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class PedidoServiceImpl implements PedidoService {

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ServicoCliente servicoCliente;

    @Override
    public Pedido buscarPedido(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new BusinnesException("Pedido com ID:"+ id +" nao foi encontrado"));
    }

    @Override
    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoFactory.fromEntity(pedidoDTO);
        pedido = repository.save(pedido);
        enviarPedidoServicoCliente(getPedidoStatus(pedido), false);
        return PedidoFactory.fromDTO(pedido);
    }

    private PedidoStatus getPedidoStatus(Pedido pedido) {
        return PedidoStatus.builder().numeroPedido(pedido.getId())
                .status(pedido.getStatus().name())
                .localizacao(pedido.getLocalizacao())
                .build();
    }

    @Override
    public PedidoDTO atualizarPedido(PedidoDTO pedidoDTO) throws IOException {
        Pedido pedido = PedidoFactory.fromEntity(pedidoDTO);
        pedido = repository.save(pedido);
        enviarPedidoServicoCliente(getPedidoStatus(pedido), true);
        return PedidoFactory.fromDTO(pedido);
    }

    private void enviarPedidoServicoCliente(PedidoStatus pedidoStatus, Boolean atualizar) {
        try {
            log.info("Enviando pedido :{} para a fila", pedidoStatus.getNumeroPedido());
            servicoCliente.enviarPedidoStatus(pedidoStatus, atualizar);

        } catch (Exception exception) {
            log.error("Falha ao tentar enviar a mensagem para a fila , erro : {}",exception.getMessage());
        }
    }


}
