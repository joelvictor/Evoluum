package br.com.evoluum.localidade.consumer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import br.com.evoluum.localidade.dto.EstadoDTO;
import br.com.evoluum.localidade.dto.LocalidadeDTO;
import br.com.evoluum.localidade.dto.MicrorregiaoDTO;
import br.com.evoluum.localidade.dto.MunicipioDTO;

@Service
public class LocalidadeConsumer {

	private Logger logger = LoggerFactory.getLogger(LocalidadeConsumer.class);
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${url.api.estados}")
	private String urlApiEstados;
	
	@Value("${url.api.municipios}")
	private String urlApiMunicipios;

	@Value("${url.api.municipios.estado}")
	private String urlApiMunicipioIdEstado;
	
	@Cacheable("estados")
	@HystrixCommand(fallbackMethod = "emptyList", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000") })
	private List<EstadoDTO> getEstados() {
		logger.info("Requisição da lista de estados");
		List<EstadoDTO> estados = Arrays.asList(restTemplate.getForEntity(urlApiEstados, EstadoDTO[].class).getBody());
		logger.info("Estados retornados com sucesso.");
		return estados;
	}
	
	
	public List<LocalidadeDTO> getLocalidades() {
		List<EstadoDTO> estados = getEstados();
	
		List<LocalidadeDTO> localidades = new ArrayList<>();
		estados.forEach(estado -> {
			List<MunicipioDTO> municipios = getMunicipiosPorEstado(estado.getId());
			localidades.addAll(municipios.stream().map(municipio -> {
				LocalidadeDTO localidade = new LocalidadeDTO();
				localidade.setIdEstado(estado.getId());
				localidade.setSiglaEstado(estado.getSigla());
				localidade.setNomeCidade(municipio.getNome());
				MicrorregiaoDTO microrregiaoDTO = municipio.getMicrorregiao();
				localidade.setNomeMesorregiao(microrregiaoDTO.getMesorregiao().getNome());
				localidade.setRegiaoNome(microrregiaoDTO.getNome());
				return localidade;
			}).collect(Collectors.toList()));
		});
				
		return localidades;
	}
	
	@HystrixCommand(fallbackMethod = "emptyList", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000") })
	private List<MunicipioDTO> getMunicipiosPorEstado(Long idEstado) {
		logger.info("Requisição de lista de município por estado");
		List<MunicipioDTO> municipios = Arrays.asList(restTemplate.getForEntity(String.format(urlApiMunicipioIdEstado, idEstado), MunicipioDTO[].class).getBody());
		logger.info("Lista de municípios por estado retornados com sucesso.");
		return municipios;
	}
	
	@Cacheable("municipios")
	@HystrixCommand(fallbackMethod = "emptyList", commandProperties = { @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "15000") })
	public List<MunicipioDTO> getMunicipios() {
		logger.info("Requisição de lista de todos os municípios");
		List<MunicipioDTO> municipios = Arrays.asList(restTemplate.getForEntity(urlApiMunicipios, MunicipioDTO[].class).getBody());
		logger.info("Lista de municípios retornados com sucesso.");
		return municipios;
	}
	
	
	public Long getMunicipioId(String nomeMunicipio) {
		Long id = null;
		MunicipioDTO municipioDTO = getMunicipios().stream().filter(municipio -> municipio.getNome().equalsIgnoreCase(nomeMunicipio)).findFirst().orElse(null);
		if (municipioDTO != null) {
			id = municipioDTO.getId();
		}
		
		return id;
	}
	
	
	public List<?> emptyList() {
		return new ArrayList<>();
	}
}
