package com.boaentrega.informacoescadastrais.repository;

import com.boaentrega.informacoescadastrais.model.Fornecedor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Long> {


   List<Fornecedor> findByEstado(String estado);


}
