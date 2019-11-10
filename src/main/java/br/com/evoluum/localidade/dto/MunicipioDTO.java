package br.com.evoluum.localidade.dto;

public class MunicipioDTO {

	private Long id;
	
	private String nome;
	
	private MicrorregiaoDTO microrregiao;

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
	 * @return the microrregiao
	 */
	public MicrorregiaoDTO getMicrorregiao() {
		return microrregiao;
	}

	/**
	 * @param microrregiao the microrregiao to set
	 */
	public void setMicrorregiao(MicrorregiaoDTO microrregiao) {
		this.microrregiao = microrregiao;
	}
	
}
