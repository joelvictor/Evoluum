package br.com.evoluum.localidade.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluum.localidade.consumer.LocalidadeConsumer;
import br.com.evoluum.localidade.dto.LocalidadeDTO;

@Service
public class LocalidadeService {
	
	private Logger logger = LoggerFactory.getLogger(LocalidadeService.class);

	@Autowired
	private LocalidadeConsumer localidadeConsumer;
	
	public List<LocalidadeDTO> findAll() {
		return localidadeConsumer.getLocalidades();
	}
	
	
}
