package com.example.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.model.Produto;

public interface ProdutoDAO extends CrudRepository<Produto, Integer>{

}
