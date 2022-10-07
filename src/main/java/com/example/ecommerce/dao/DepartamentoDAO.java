package com.example.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.ecommerce.model.Departamento;

public interface DepartamentoDAO extends CrudRepository<Departamento, Integer>{ //deve ser passado o tipo do elemento que vai ser a classe e o tipo de dado da chave primária
	
	

}
