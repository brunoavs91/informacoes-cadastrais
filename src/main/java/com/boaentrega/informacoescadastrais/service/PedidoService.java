package com.boaentrega.informacoescadastrais.service;

import com.boaentrega.informacoescadastrais.model.Pedido;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;

import java.io.IOException;

public interface PedidoService {

    Pedido buscarPedido(Long id);

    PedidoDTO salvarPedido(PedidoDTO pedidoDTO) throws IOException;

    PedidoDTO atualizarPedido(PedidoDTO pedidoDTO) throws IOException;
}
