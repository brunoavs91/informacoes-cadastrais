package com.boaentrega.informacoescadastrais.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer tempoDePreparo;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pedidoId")
    private List<ItemPedido> itens;

//    public Pedido(List<ItemPedido> itens) {
//        this.itens = itens;
//        this.status = StatusPedido.RECEBIDO;
//    }

}
