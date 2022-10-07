package com.example.ecommerce.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//sinaliza que a classe pode ser armazenada no banco
@Entity
//sinaliza em qual tabela será armazenado
@Table(name="departamento")

public class Departamento {

	@Column(name = "codigo") // aqui é necessario declarar caso o nome do atributo seja diferente do banco de daos
	@Id //identifica que o atributo é primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //esse indica que é auto incrementavel no banco
	private Integer codigo;
	
	@Column(name="nome", length = 50, nullable = false)
	private String nome;
	
	@Column(name="descricao", nullable = true, columnDefinition = "TEXT")
	private String descricao;
	
	//             ---------- para listar todos os produtos que estão contidos no departamento
	//no mappedby passa-se o aributo na classe Produto que está apontando para o departamento (não é a colunasql)
	//cascaded faz com que a alteração no departamento leve as alterações para todas as tabelas
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
	//para ignorar o retorno do produto para o departamento e não ficar em loop
	@JsonIgnoreProperties("departamento")
	private List<Produto> listaProdutos;
	
	
	
//getters and setters
	
	
	public Integer getCodigo() {
		return codigo;
	}

	public List<Produto> getListaProdutos() {
		return listaProdutos;
	}

	public void setListaProdutos(List<Produto> listaProdutos) {
		this.listaProdutos = listaProdutos;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
	
	
}

