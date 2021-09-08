package com.boaentrega.informacoescadastrais.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemPedidoDTO {

    private Long id;

    private Integer quantidade;

    private ProdutoDTO produto;

}
