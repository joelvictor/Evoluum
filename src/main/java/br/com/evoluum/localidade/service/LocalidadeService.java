package br.com.evoluum.localidade.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluum.localidade.consumer.LocalidadeConsumer;
import br.com.evoluum.localidade.dto.LocalidadeDTO;
import br.com.evoluum.localidade.dto.TipoRetorno;
import br.com.evoluum.localidade.util.CsvGenerator;

@Service
public class LocalidadeService {
	
	private Logger logger = LoggerFactory.getLogger(LocalidadeService.class);

	@Autowired
	private LocalidadeConsumer localidadeConsumer;
	
	public Object buscarTodasLocalidades(TipoRetorno tipoRetorno) {
		Object resultado = null;
		List<LocalidadeDTO> localidades = localidadeConsumer.getLocalidades();
		switch (tipoRetorno) {
			case CSV:
				resultado = CsvGenerator.gerarLocalidadeCSV(localidades);
			break;
			case JSON:
			default:
				resultado = localidades;
			break;
		}
		
		return resultado;
	}
	

	
	public Long buscarMunicipio(String nomeMunicipio) {
		return localidadeConsumer.getMunicipioId(nomeMunicipio);
	}
	
	
}
