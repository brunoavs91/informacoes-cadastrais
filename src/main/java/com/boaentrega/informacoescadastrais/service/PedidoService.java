package com.boaentrega.informacoescadastrais.service;

import com.boaentrega.informacoescadastrais.model.Pedido;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;

public interface PedidoService {

    Pedido buscarPedido(Long id);

    PedidoDTO salvarPedido(PedidoDTO pedidoDTO);
}
