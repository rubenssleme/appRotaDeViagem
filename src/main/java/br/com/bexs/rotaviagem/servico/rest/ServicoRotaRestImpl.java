package br.com.bexs.rotaviagem.servico.rest;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.bexs.rotaviagem.dominio.Rota;
import br.com.bexs.rotaviagem.dto.ResultadoBuscaRotaDTO;
import br.com.bexs.rotaviagem.dto.ResultadoEdicaoRotaDTO;
import br.com.bexs.rotaviagem.dto.RotaDTO;
import br.com.bexs.rotaviagem.repositorio.RepositorioRota;



@Component
public class ServicoRotaRestImpl implements ServicoRota {
	@Autowired
	private RepositorioRota repositorioRota;

	@Override
	public ResultadoEdicaoRotaDTO inserir(RotaDTO rotaDTO) {
		ResultadoEdicaoRotaDTO resultaEdicaoRota = new ResultadoEdicaoRotaDTO();

		Rota rota = new Rota(rotaDTO.obterInformacaoRota());

	
		rota.validarCampoObrigatorio();
		if (rota.validado()) {
			if (repositorioRota.inserirRota(rota)) {
				resultaEdicaoRota.markAsSuccessful();
			} else {
				resultaEdicaoRota.addError("Error while saving the " + rota + " to file");
			}
		} else {
			resultaEdicaoRota.addError(rota.obterDescricaoDosErros());
		}

		return resultaEdicaoRota;
	}
	
	@Override
	public ResultadoBuscaRotaDTO fetchBestRoute(RotaDTO rotaDTO) {
		ResultadoBuscaRotaDTO resultadoBuscaRota = new ResultadoBuscaRotaDTO();

		Rota rodaSaidaContraMelhorRota = new Rota(rotaDTO.obterInformacaoRota());

		rodaSaidaContraMelhorRota.validarInformeDaRota();;

		if (rodaSaidaContraMelhorRota.validado()) {
			Rota bestRoute = repositorioRota.obterMelhorRota(rodaSaidaContraMelhorRota);

			if (bestRoute != null) {
				resultadoBuscaRota.setBestRoute(bestRoute);
			} else {
				resultadoBuscaRota.setErrors(Arrays.asList("A rota não foi encontrada " + rodaSaidaContraMelhorRota.obterInformacaoRota() + " - " + rodaSaidaContraMelhorRota.obterDestino()));
			}
		} else {
			resultadoBuscaRota.setErrors(rodaSaidaContraMelhorRota.obterErros());
		}

		return resultadoBuscaRota;
	}

}
