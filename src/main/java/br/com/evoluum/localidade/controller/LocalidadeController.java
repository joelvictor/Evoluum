package br.com.evoluum.localidade.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.localidade.dto.TipoRetorno;
import br.com.evoluum.localidade.service.LocalidadeService;
import io.swagger.annotations.Api;

/**
 * Controller responsável pelos endpoints de localidade 
 * 
 * @author Joel Victor
 *
 */
@Api(value = "Localidade")
@RestController
@RequestMapping(value = "/v1/localidade")
public class LocalidadeController {

	
	private Logger logger = LoggerFactory.getLogger(LocalidadeController.class);
	
	@Autowired
	private LocalidadeService localidadeService;
	
	@GetMapping
	public ResponseEntity<?> buscarTodasLocalidadesJSON() {
		logger.info("Busca todas as cidades - json");
		
		return new ResponseEntity<>(localidadeService.buscarTodasLocalidades(TipoRetorno.JSON), HttpStatus.OK);
	}
	
	@GetMapping(value = "/csv", produces = "text/csv")
	public ResponseEntity<?> buscarTodasLocalidadesCSV() {
		logger.info("Busca todas as cidades - csv");
		return new ResponseEntity<>(localidadeService.buscarTodasLocalidades(TipoRetorno.CSV), HttpStatus.OK);
	}
	
	@Cacheable("buscarCidade")
	@GetMapping("/{nomeMunicipio}")
	public ResponseEntity<?> buscarMunicipio(String nomeMunicipio) {
		logger.info("Busca de cidade pelo nome");

		return new ResponseEntity<>(localidadeService.buscarMunicipio(nomeMunicipio), HttpStatus.OK);
	}
	
}
