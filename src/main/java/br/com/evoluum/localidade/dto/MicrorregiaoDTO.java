package br.com.evoluum.localidade.dto;

public class MicrorregiaoDTO {

	private Long id;
	
	private String nome;
	
	private MesorregiaoDTO mesorregiao;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	public MesorregiaoDTO getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(MesorregiaoDTO mesorregiao) {
		this.mesorregiao = mesorregiao;
	}
	
	
	
	
}
