package com.boaentrega.informacoescadastrais.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoDTO {

    private Long id;

    private Integer tempoDePreparo;

    private String status;

    private List<ItemPedidoDTO> itens;

}
