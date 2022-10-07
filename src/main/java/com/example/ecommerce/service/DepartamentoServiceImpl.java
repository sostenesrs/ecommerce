package com.example.ecommerce.service;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.dao.DepartamentoDAO;
import com.example.ecommerce.model.Departamento;

//anotação para no controller fazer a injeção do serviço
@Service

public class DepartamentoServiceImpl implements IDepartamentoService {
	
	@Autowired
	private DepartamentoDAO dao;

	@Override
	public Departamento criarNovo(Departamento novo) {
		if(novo.getNome()!=null) {
			return dao.save(novo);
		}
		
		return null;
	}

	
	//se a chave primaria estiver preenchida ele faz update, se estiver vazia ele cria um novo
	@Override
	public Departamento atualizarDados(Departamento dados) {
		if(dados.getCodigo()!= null && dados.getNome()!=null) {
			return dao.save(dados);
		}
		return null;
	}

	@Override
	public ArrayList<Departamento> buscarTodos() {
		// TODO Auto-generated method stub
		return (ArrayList<Departamento>)dao.findAll();
	}

	@Override
	public Departamento buscarPeloId(Integer id) {
		//encontra pelo id, senão da else = null
		return dao.findById(id).orElse(null) ;
	}

	@Override
	public void excluirDepartamento(Integer id) {
		//apaga registro pelo id
		dao.deleteById(id);
		
	}

}
