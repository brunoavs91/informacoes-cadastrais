package com.boaentrega.informacoescadastrais.repository;

import com.boaentrega.informacoescadastrais.model.Pedido;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
