package br.com.bexs.rotaviagem.dto;

public class RotaDTO {
	private String informacaoRota;

	public RotaDTO() {
	}
	
	public RotaDTO(String informacaoRota) {
		super();
		this.informacaoRota = informacaoRota;
	}

	public String obterInformacaoRota() {
		return informacaoRota;
	}

	public void atribuirInformacaoRota(String informacaoRota) {
		this.informacaoRota = informacaoRota;
	}
}
