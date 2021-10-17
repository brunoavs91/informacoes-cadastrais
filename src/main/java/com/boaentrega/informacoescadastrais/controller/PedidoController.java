package com.boaentrega.informacoescadastrais.controller;

import com.boaentrega.informacoescadastrais.model.dto.FornecedorDTO;
import com.boaentrega.informacoescadastrais.model.dto.PedidoDTO;
import com.boaentrega.informacoescadastrais.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

  @Autowired
  private PedidoService service;

    @GetMapping
    @PreAuthorize("hasAuthority('USER_COLAB') or hasAuthority('ADMIN_CLIENT')")
    public ResponseEntity getPedido(@RequestParam Long id){

        return ResponseEntity.ok().body(service.buscarPedido(id));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER_COLAB') or hasAuthority('ADMIN_CLIENT')")
    public ResponseEntity salvarPedido(@RequestBody PedidoDTO pedidoDTO) throws IOException {

        return ResponseEntity.ok().body(service.salvarPedido(pedidoDTO));
    }

  @PutMapping
  @PreAuthorize("hasAuthority('USER_COLAB') or hasAuthority('ADMIN_CLIENT')")
  public ResponseEntity atualizar(@RequestBody PedidoDTO pedidoDTO) throws IOException {

    return ResponseEntity.ok().body(service.atualizarPedido(pedidoDTO));
  }
}
