package com.apirest.webflux.document;

import java.util.List;

//@Document(value = "tipoAnimal")
public class TipoAnimal {

//	@Id
	private String codigo;
	
	private String descricao;
	
//	@DBRef
	private List<RacaAnimal> racas;
	
	public TipoAnimal() {
		super();
	}

	public TipoAnimal(String codigo, String descricao, List<RacaAnimal> racas) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.racas = racas;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<RacaAnimal> getRacas() {
		return racas;
	}

	public void setRacas(List<RacaAnimal> racas) {
		this.racas = racas;
	}
}