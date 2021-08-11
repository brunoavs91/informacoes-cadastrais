package com.boaentrega.informacoescadastrais.service.impl;

import com.boaentrega.informacoescadastrais.model.Fornecedor;
import com.boaentrega.informacoescadastrais.repository.FornecedorRepository;
import com.boaentrega.informacoescadastrais.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    @Override
    public Fornecedor getFornecedorByEstado(String estado) {
        return repository.findByEstado(estado);
    }
}
