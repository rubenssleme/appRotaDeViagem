package br.com.bexs.rotaviagem.servico.rest;

import br.com.bexs.rotaviagem.dto.ResultadoBuscaRotaDTO;
import br.com.bexs.rotaviagem.dto.ResultadoEdicaoRotaDTO;
import br.com.bexs.rotaviagem.dto.RotaDTO;

public interface ServicoRota {
	
	public ResultadoEdicaoRotaDTO inserir(RotaDTO rota);
	public ResultadoBuscaRotaDTO fetchBestRoute(RotaDTO rota);

}
