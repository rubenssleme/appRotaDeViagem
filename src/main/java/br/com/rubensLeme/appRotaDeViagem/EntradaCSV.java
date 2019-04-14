package br.com.rubensLeme.appRotaDeViagem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EntradaCSV {

	
//	public static void calcularMelhorRota(String rota) {
//		String[] rota1  = rota.split(",");
//		String saidaRota = rota1[rota1.length -3].toString();
//		String destinoRota = rota1[rota1.length - 2].toString();
//		String valorRota = rota1[rota1.length - 1].toString();
//		System.out.println(rota1.length + "\n");
//		System.out.println(rota);
//		String saida = "SCL";
//		String destino = "ORL";
//		String valor = "20";
//		int i;
//		
//		if ((saida.equals(saidaRota)) && (destino.equals(destinoRota)) && (valor.equals(valorRota))) {
//			i=0;	
//			System.out.printf("\nPercorrendo array usando for-each:\n");
//		    for(String contato : rota1) {
//			   System.out.printf("Posição:%d : %s - ",i ,contato);
//			   i++;
//			}
//		}
//
//	}

	public static void trataLista(List<String> rota) {
		System.out.println(rota.get(0));
		// System.out.println(rota.get(1));
	}

	public List<String> executar() throws FileNotFoundException {
		BufferedReader br = null;
		String linha = "";
		br = new BufferedReader(new FileReader("input-file.csv"));
		String[] rota2 = null;
		List<String> retorno = null;
		try {
			while ((linha = br.readLine()) != null) {
				String[] pais = linha.split(",");
				System.out.println("País [code= "+ pais[pais.length - 3]+ " , name="  + pais[pais.length - 2] + " , name=" + pais[pais.length - 1] + "]");
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retorno;
	}

}
