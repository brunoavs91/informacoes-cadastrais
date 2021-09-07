package com.boaentrega.informacoescadastrais.service;

import com.boaentrega.informacoescadastrais.model.Fornecedor;
import com.boaentrega.informacoescadastrais.model.dto.FornecedorDTO;

import java.util.List;

public interface FornecedorService {

    List<Fornecedor> getFornecedorByEstado(String estado);

    FornecedorDTO salvarFornecedor(FornecedorDTO dto);
}
