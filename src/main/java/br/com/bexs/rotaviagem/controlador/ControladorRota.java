package br.com.bexs.rotaviagem.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bexs.rotaviagem.dto.ResultadoBuscaRotaDTO;
import br.com.bexs.rotaviagem.dto.ResultadoEdicaoRotaDTO;
import br.com.bexs.rotaviagem.dto.RotaDTO;
import br.com.bexs.rotaviagem.servico.rest.RestContrato;
import br.com.bexs.rotaviagem.servico.rest.ServicoRota;
@RestController
public class ControladorRota {
	@Autowired
	private ServicoRota serviceRoute;

	@PostMapping(RestContrato.URL_ROTAS)
	public ResultadoEdicaoRotaDTO saveNewRoute(@RequestBody RotaDTO rotaDto) {
		return serviceRoute.inserir(rotaDto);
	}

	@GetMapping(RestContrato.URL_OBTER_MELHOR_ROTA)
	public ResultadoBuscaRotaDTO fetchBestRoute(@PathVariable(RestContrato.PARAMETRO_INFO_ROTA) String text) {
		return serviceRoute.fetchBestRoute(new RotaDTO(text));
	}
}
