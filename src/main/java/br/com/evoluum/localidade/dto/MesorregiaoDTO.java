package br.com.evoluum.localidade.dto;

public class MesorregiaoDTO {

	private Long id;
	
	private String nome;
	
	private EstadoDTO uf;

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

	/**
	 * @return the uf
	 */
	public EstadoDTO getUf() {
		return uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(EstadoDTO uf) {
		this.uf = uf;
	}
	
	
	
}
