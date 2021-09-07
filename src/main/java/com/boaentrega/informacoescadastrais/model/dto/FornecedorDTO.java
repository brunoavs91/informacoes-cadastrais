package com.boaentrega.informacoescadastrais.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FornecedorDTO {

    private Long id;

    private String nome;

    private String estado;

    private String endereco;
}
