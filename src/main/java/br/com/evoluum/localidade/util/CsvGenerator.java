package br.com.evoluum.localidade.util;

import java.util.List;

import br.com.evoluum.localidade.dto.LocalidadeDTO;

public class CsvGenerator {

	
	public static byte[] gerarLocalidadeCSV(List<LocalidadeDTO> localidades) {
		StringBuilder csvBuilder = new StringBuilder();
		csvBuilder.append("idEstado,siglaEstado,regiaoNome,nomeCidade,nomeMesorregiao,nomeFormatado\n");
		localidades.forEach(localidade-> {
			csvBuilder.append(localidade.getIdEstado() + "," );
			csvBuilder.append(localidade.getSiglaEstado() + "," );
			csvBuilder.append(localidade.getRegiaoNome() + "," );
			csvBuilder.append(localidade.getNomeCidade() + "," );
			csvBuilder.append(localidade.getNomeMesorregiao() + "," );
			csvBuilder.append(localidade.getNomeFormatado());
		});
		
		return generateCSV(csvBuilder.toString());
	}
	
	private static byte[] generateCSV(String dados) {
		
		return null;
	}
	
	
}
