package com.boaentrega.informacoescadastrais.controller;

import com.boaentrega.informacoescadastrais.client.ServicoCliente;
import com.boaentrega.informacoescadastrais.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {


    @Autowired
    Environment environment;

    @Autowired
    private ServicoCliente cliente;

    @Autowired
    private FornecedorService service;

    @GetMapping
    public String getTeste(){
        return "testando API";
    }

    @GetMapping("/cliente")
    public String getTestApiClient(){
        return cliente.getTesteClient();
    }
}
