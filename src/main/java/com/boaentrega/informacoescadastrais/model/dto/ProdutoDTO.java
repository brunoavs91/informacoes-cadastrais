package com.boaentrega.informacoescadastrais.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutoDTO {

    private Long id;

    private String nome;

    private String estado;

    private String descricao;

    private BigDecimal preco;
}
