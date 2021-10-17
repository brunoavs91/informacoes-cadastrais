package com.boaentrega.informacoescadastrais.client;

import com.boaentrega.informacoescadastrais.model.dto.PedidoStatus;

import java.io.IOException;

public interface ServicoCliente {

     String getTesteClient();
     void enviarPedidoStatus(PedidoStatus pedidoStatus, Boolean atualizar) throws IOException;

}
