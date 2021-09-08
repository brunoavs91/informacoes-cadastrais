package com.boaentrega.informacoescadastrais.service.impl;

import com.boaentrega.informacoescadastrais.exception.BusinnesException;
import com.boaentrega.informacoescadastrais.model.ItemPedido;
import com.boaentrega.informacoescadastrais.model.Pedido;
import com.boaentrega.informacoescadastrais.model.Produto;
import com.boaentrega.informacoescadastrais.model.dto.ItemPedidoDTO;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;
import com.boaentrega.informacoescadastrais.model.dto.ProdutoDTO;
import com.boaentrega.informacoescadastrais.model.factory.PedidoFactory;
import com.boaentrega.informacoescadastrais.repository.PedidoRepository;
import com.boaentrega.informacoescadastrais.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    private PedidoRepository repository;

    @Override
    public Pedido buscarPedido(Long id) {
        return repository.findById(id)
                .orElseThrow(()-> new BusinnesException("Pedido com ID:"+ id +" nao foi encontrado"));
    }

    @Override
    public PedidoDTO salvarPedido(PedidoDTO pedidoDTO) {
        Pedido pedido = PedidoFactory.fromEntity(pedidoDTO);
        pedido = repository.save(pedido);
        return PedidoFactory.fromDTO(pedido);
    }


}
