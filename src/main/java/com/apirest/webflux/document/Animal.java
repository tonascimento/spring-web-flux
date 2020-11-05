package com.apirest.webflux.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "animal")
public class Animal {

	@Id
	private String codigo;
	
	private String nome;
	
	private TipoAnimal tipoAnimal;
	

	public Animal() {
		super();
	}

	public Animal(String nome, TipoAnimal tipoAnimal) {
		super();
		this.nome = nome;
		this.tipoAnimal = tipoAnimal;
	}

	public Animal(String codigo, String nome, TipoAnimal tipoAnimal) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipoAnimal = tipoAnimal;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoAnimal getTipoAnimal() {
		return tipoAnimal;
	}

	public void setTipoAnimal(TipoAnimal tipoAnimal) {
		this.tipoAnimal = tipoAnimal;
	}
}