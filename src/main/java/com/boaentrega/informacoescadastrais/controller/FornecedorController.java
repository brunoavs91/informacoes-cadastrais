package com.boaentrega.informacoescadastrais.controller;

import com.boaentrega.informacoescadastrais.model.dto.FornecedorDTO;
import com.boaentrega.informacoescadastrais.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {


    @Autowired
    private FornecedorService service;

    @GetMapping
    @PreAuthorize("hasAuthority('USER_COLAB') or hasAuthority('USER_CLIENT')")
    public ResponseEntity getFornecedor(@RequestParam String estado){

       return ResponseEntity.ok().body(service.getFornecedorByEstado(estado));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER_COLAB')")
    public ResponseEntity salvarFornecedor(@RequestBody FornecedorDTO fornecedorDTO){

        return ResponseEntity.ok().body(service.salvarFornecedor(fornecedorDTO));
    }

}
