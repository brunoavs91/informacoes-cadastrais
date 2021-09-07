package com.boaentrega.informacoescadastrais.controller;

import com.boaentrega.informacoescadastrais.model.Fornecedor;
import com.boaentrega.informacoescadastrais.model.dto.FornecedorDTO;
import com.boaentrega.informacoescadastrais.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {


    @Autowired
    private FornecedorService service;

    @GetMapping
    public ResponseEntity getFornecedor(@RequestParam String nome){

       return ResponseEntity.ok().body(service.getFornecedorByEstado(nome));
    }

    @PostMapping
    public ResponseEntity salvarFornecedor(@RequestBody FornecedorDTO fornecedorDTO){

        return ResponseEntity.ok().body(service.salvarFornecedor(fornecedorDTO));
    }

}
