package br.com.bexs.rotaviagem.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Rota {
	private final String LIMITE_USANDO_VIRGULA = ",";
	private final String LIMITE_USANDO_YFEN = "-";
	

	private String informacaoRota;
	private Double valor;
	private boolean validado;
	private List<String> locais;
	private List<String> erros;
	
	int i;

	public Rota() {
		erros = new ArrayList<>();
		locais = new ArrayList<>();
		validado = true;
	}

	
	public Rota(String obterInformacaoRota) {
		this();
		atribuirInformacaoRota(informacaoRota);
		init();
	}


	private void init() {
		if (informacaoRota != null && !informacaoRota.isEmpty()) {
			String[] informacaoRotaSplitted = null;

			if (informacaoRota.contains(LIMITE_USANDO_VIRGULA)) {
				informacaoRotaSplitted = informacaoRota.split(LIMITE_USANDO_VIRGULA);
			} else if (informacaoRota.contains(LIMITE_USANDO_YFEN)) {
				informacaoRotaSplitted = informacaoRota.split(LIMITE_USANDO_YFEN);
			} else {
				validado = false;
				erros.add("A melhor rota não foi encontrada. Dado entrada: " + informacaoRota
						+ " é inválido. Adicione uma entrada válida, por exemplo: GRU-CDG or GRU-BRC-CDG");
			}

			if (informacaoRotaSplitted != null) {
				for (String infoRoute : informacaoRotaSplitted) {
					infoRoute = infoRoute.replaceAll("\\s+", "");

					if (infoRoute.matches("[a-zA-Z]+") && infoRoute.length() == 3) {
						locais.add(infoRoute);
					} else {
						try {
							valor = Double.parseDouble(infoRoute);
						} catch (Exception e) {
							valor = null;
						}
					}
				}
				atualizarRotaComPrecoCorrigido();
			}
		}

		
	}


	private void atualizarRotaComPrecoCorrigido() {
		this.informacaoRota = completarInformacoes().replaceAll("\n", "");
	}
	
	public String completarInformacoes() {
		return "\n" + locais.stream().map(String::toString).collect(Collectors.joining(","))+","+ valor;
	}
	
	
	public String obterInformacaoRota() {
		return informacaoRota;
	}
	
	public void atribuirInformacaoRota(String informacaoRota) {
		this.informacaoRota = informacaoRota != null && !informacaoRota.isEmpty() ? informacaoRota.toUpperCase() : "";
	}
	
	public String obterSaida() {
		return locais.stream().findFirst().orElse("");
	}

	public void atribuirSaida(String Saida) {
		this.locais.set(0, Saida);
	}
	
	public String obterDestino() {
		return locais.stream().skip(locais.stream().count() - 1).findFirst().orElse("");
	}

	public void atribuirDestino(String Destino) {
		this.locais.set(locais.size() - 1, Destino);
	}
	
	public double obterValor() {
		return valor;
	}
	
	public void atribuirValor(double valor) {
		this.valor = valor;
	}
	
	public List<String> obterErros() {
		return erros;
	}

	public void atribuirErros(List<String> erros) {
		this.erros = erros;
	}

	public String obterDescricaoDosErros() {
		return erros.stream().map(String::toString).findFirst().orElse("");
	}
	
	public boolean validado() {
		return validado;
	}

	public void validarCampoObrigatorio() {
		validarInformeDaRota();
		if (valor == null) {
			validado = false;
			erros.add("Adicione um preço válido");
		}
	}
	public void validarInformeDaRota() {
		if (informacaoRota == null || informacaoRota.isEmpty() || informacaoRota.chars().noneMatch(Character::isLetterOrDigit)) {
			validado = false;
			erros.add("Adicione um trajeto válido");
		}
	}
	
	
	public String informacaoSaida() {
		return locais.stream().map(String::toString).collect(Collectors.joining(",")) + " > $" + valor;
	}

	public String complementoDeInformacao() {
		return "\n" + locais.stream().map(String::toString).collect(Collectors.joining(",")) + "," + valor;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((informacaoRota == null) ? 0 : informacaoRota.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rota other = (Rota) obj;
		if (informacaoRota == null) {
			if (other.informacaoRota != null)
				return false;
		} else if (!informacaoRota.equals(other.informacaoRota))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Rota [Informação da Rota=" + informacaoRota + ", validado=" + validado + ", erros=" + erros + "]";
	}
	
}
