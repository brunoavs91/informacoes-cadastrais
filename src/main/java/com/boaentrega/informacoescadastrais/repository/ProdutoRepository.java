package com.boaentrega.informacoescadastrais.repository;

import com.boaentrega.informacoescadastrais.model.Produto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
