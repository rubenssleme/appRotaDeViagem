package br.com.bexs.rotaviagem;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class PersistirNovaRota {

//	public static void main(String[] args) {
//		atribuirBarrasAoArquivo();
//	
//	escrever(atribuirBarrasAoArquivo()+"input-file.csv", "DDD-RRR3");
//
//	}

	public static void gravarNovaRota(String path, String novaRota) {
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(novaRota);
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static String obterDiretorioAplicacao() {
		return System.getProperty("user.dir");
	}

	private static String atribuirBarrasAoArquivo() {
		String linha = obterDiretorioAplicacao();
		linha = linha.replace("\\", "\\\\");
		return linha + "\\";
	}
}
