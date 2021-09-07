package com.boaentrega.informacoescadastrais.service.impl;

import com.boaentrega.informacoescadastrais.model.Fornecedor;
import com.boaentrega.informacoescadastrais.model.dto.FornecedorDTO;
import com.boaentrega.informacoescadastrais.repository.FornecedorRepository;
import com.boaentrega.informacoescadastrais.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;



    @Override
    public List<Fornecedor> getFornecedorByEstado(String estado) {

        return repository.findByEstado(estado.toUpperCase());
    }

    @Override
    public FornecedorDTO salvarFornecedor(FornecedorDTO dto) {
        Fornecedor fornecedor = Fornecedor.builder()
                .nome(dto.getNome())
                .endereco(dto.getEndereco()).estado(dto.getEstado().toUpperCase()).build();
        fornecedor = repository.save(fornecedor);
        return FornecedorDTO.builder().id(fornecedor.getId())
                .endereco(fornecedor.getEndereco())
                .nome(fornecedor.getNome()).estado(fornecedor.getEstado()).build();
    }


}
