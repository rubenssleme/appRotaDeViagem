package br.com.bexs.rotaviagem.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.bexs.rotaviagem.dominio.Rota;

public class ResultadoBuscaRotaDTO {
	private boolean successo;
	private List<String> erros;
	private Rota melhorRota;

	public ResultadoBuscaRotaDTO() {
		erros = new ArrayList<>();
	}

	public String getBestRoute() {
		return melhorRota != null ? melhorRota.obterInformacaoRota() : "";
	}

	public void setBestRoute(Rota melhorRota) {
		this.melhorRota = melhorRota;
		successo = true;
	}

	public List<String> getErros() {
		return erros;
	}

	public void setErrors(List<String> erros) {
		successo = false;
		this.erros = erros;
	}

	public boolean isSuccess() {
		return successo;
	}

	public void setSuccess(boolean successo) {
		this.successo = successo;
	}
}
