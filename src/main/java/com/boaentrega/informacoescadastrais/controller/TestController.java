package com.boaentrega.informacoescadastrais.controller;

import com.boaentrega.informacoescadastrais.client.ServicoCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TestController {

    @Autowired
    private ServicoCliente cliente;

    @GetMapping
    public String getTeste(){
        return "testando API";
    }

    @GetMapping("/cliente")
    public String getTestApiClient(){
        return cliente.getTesteClient();
    }
}
