package br.com.evoluum.localidade.dto;

import org.springframework.util.StringUtils;

public class LocalidadeDTO {

	private Long idEstado;
	
	private String siglaEstado;
	
	private String regiaoNome;
	
	private String nomeCidade;
	
	private String nomeMesorregiao;
	
	private String nomeFormatado;
	
	public LocalidadeDTO() {
		super();
	}

	/**
	 * @return the idEstado
	 */
	public Long getIdEstado() {
		return idEstado;
	}

	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	/**
	 * @return the siglaEstado
	 */
	public String getSiglaEstado() {
		return siglaEstado;
	}

	/**
	 * @param siglaEstado the siglaEstado to set
	 */
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	/**
	 * @return the regiaoNome
	 */
	public String getRegiaoNome() {
		return regiaoNome;
	}

	/**
	 * @param regiaoNome the regiaoNome to set
	 */
	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}

	/**
	 * @return the nomeCidade
	 */
	public String getNomeCidade() {
		return nomeCidade;
	}

	/**
	 * @param nomeCidade the nomeCidade to set
	 */
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}

	/**
	 * @return the nomeMesorregiao
	 */
	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}

	/**
	 * @param nomeMesorregiao the nomeMesorregiao to set
	 */
	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}

	/**
	 * @return the nomeFormatado
	 */
	public String getNomeFormatado() {
		if (!StringUtils.isEmpty(nomeCidade) && !StringUtils.isEmpty(siglaEstado)) {
			nomeFormatado = nomeCidade + "/" + siglaEstado;
		}
		return nomeFormatado;
	}

}
