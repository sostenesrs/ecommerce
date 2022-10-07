package com.example.ecommerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommerce.dao.DepartamentoDAO;
import com.example.ecommerce.model.Departamento;
import com.example.ecommerce.service.IDepartamentoService;

import net.bytebuddy.asm.Advice.Return;

//sinaliza que a classe DepartamentoController atende requisições via web;
@RestController
 

public class DepartamentoController {
	//faz com que não seja necessario declarar todos os métodos da classe dao, que é interface
	@Autowired 
	//implementa a calsse departamentoDao sem precisar implementar os métodos 
	private IDepartamentoService service;
	
	//declara a rota 
	@GetMapping("/departamentos")
	//declaração do método 
	public ArrayList<Departamento> recuperarTodos(){
		
		return service.buscarTodos(); //metodo do service
		 
	}
	
	
	//inclusão
	@PostMapping("/departamentos")
	//o método response entity dá o retorno exato da operação // é como da pra visualizar os códigos de retorno da requisição
	public ResponseEntity<Departamento> incluirNovo(@RequestBody Departamento novo) {
		Departamento res = service.criarNovo(novo);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.badRequest().build();
	}
	
	
	@PutMapping("/departamentos")
	//faz alteração no registro se passado id e nome
	public ResponseEntity<Departamento> alterar(@RequestBody Departamento dados){
		Departamento res = service.atualizarDados(dados);
		
		if(res != null) {
			return ResponseEntity.ok(res);
		} 
		return ResponseEntity.badRequest().build();
	}
	
	//preciso passar o id pra saber qual vai deletar
	@DeleteMapping("/departamentos/{id}")
	
	public ResponseEntity<Departamento> excluirDepartamento( @PathVariable Integer id){ //path variable indica que o id vem do caminho
		service.excluirDepartamento(id);
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/departamentos/{codigo}")
	public ResponseEntity<Departamento> buscarPeloId(@PathVariable Integer codigo){
		Departamento res = service.buscarPeloId(codigo);
		if(res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}
	
	

}
