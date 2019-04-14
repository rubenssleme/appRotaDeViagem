package br.com.rubensLeme.appRotaDeViagem;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ServicoRota {

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception, Throwable {
		
		criarBanco();
		//rota.calculaMelhorRota("GRU","BRC","10");
	}

	private static void criarBanco() throws FileNotFoundException, IOException, Exception, Throwable {
		Banco banco = new Banco();
		//Rota rota = new Rota();
		Banco.adicionaRotaArquivo();
		System.out.println(banco.getRota());
		//System.out.println(banco.buscaRotaPeloMenorValor("GRU", "CDG"));
		
		banco.buscaRotaPeloMenorValor2("GRU", "CDG");
		//System.out.println(banco.buscaContatoPeloId(5));
			
	}

}
