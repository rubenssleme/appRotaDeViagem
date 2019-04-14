package br.com.rubensLeme.appRotaDeViagem;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class GravarRotasNovas {

//	public static void main(String[] args) {
//		atribuirBarrasAoArquivo();
//	
//	escrever(atribuirBarrasAoArquivo()+"input-file.csv", "DDD-RRR3");
//
//	}

	public static void escrever(String path, String texto) {
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(texto);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String obterDiretorioAplicacao() {
		return System.getProperty("user.dir");
	}

	public static String atribuirBarrasAoArquivo() {
		String linha = obterDiretorioAplicacao();
		linha = linha.replace("\\", "\\\\");
		return linha + "\\";
	}
}
