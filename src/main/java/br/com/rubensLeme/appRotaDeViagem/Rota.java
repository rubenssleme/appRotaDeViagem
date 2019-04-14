package br.com.rubensLeme.appRotaDeViagem;

import java.util.Comparator;

public class Rota {

	private int id;
	private String saida;
	private String destino;
	private int valor;
	int i;

	public Rota() {

	}

	public Rota(int id, String saida, String destino, String valor) {
		this.id = id;
		this.saida = saida;
		this.destino = destino;
		this.valor = Integer.parseInt(valor);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSaida() {
		return saida;
	}

	public void setSaida(String saida) {
		this.saida = saida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "\nRota [id=" + id + ", saida=" + saida + ", destino=" + destino + ", valor=" + valor + "]";
	}

	
	
//	public static Comparator<Rota> COMPARE_BY_VALOR = new Comparator<Rota>() {
//        public int compare(Rota one, Rota other) {
//            return one.name.compareTo(other.name);
//        }
//    };
	
}
