package com.example.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.model.Produto;
import com.example.ecommerce.service.IProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	private IProdutoService service;
	
	//recuperar todos
	@GetMapping("/produtos")
	public ArrayList<Produto> recuperarTodos(){
		return service.recuperarTodos();
	}
	
	//recuperar pelo id
	
	
	
	//cadastrar noov
	
}
