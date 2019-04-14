package br.com.rubensLeme.appRotaDeViagem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Banco {

	private static List<Rota> rotas = new ArrayList<Rota>();

	private static int chave = 1;

	public void adiciona(Rota rota) {
		rota.setId(chave++);
		Banco.rotas.add(rota);
	}

	public List<Rota> getRota() {
		return Banco.rotas;
	}

	public void removeRota(Integer id) {

		Iterator<Rota> it = rotas.iterator();

		while (it.hasNext()) {
			Rota emp = it.next();

			if (emp.getId() == id) {
				it.remove();
			}
		}
	}

	public Rota buscaContatoPeloId(Integer id) {
		for (Rota rota : rotas) {
			if (rota.getId() == id) {
				return rota;
			}
		}
		return null;
	}

	public Rota buscaRotaPeloMenorValor(String saida, String destino) {
		for (Rota rota : rotas) {

//			if ((rota.getSaida().equals(saida)&&(rota.getDestino().equals(destino)))) {
//				if((rota.getValor().equals(saida)) {
//					return rota;
//				}
//				
//			}
		}
		return null;
	}

	public void buscaRotaPeloMenorValor2(String saida, String destino) {
		List<Rota> tempPersons = rotas.stream().filter((Rota p) -> p.getSaida().equals(saida))
				.filter((Rota p) -> p.getDestino().equals(destino)).collect(Collectors.toList());

		if (tempPersons.size() == 1) {
			tempPersons.forEach(System.out::println);
		} else {

			System.out.println("Maior que 1");
		}

	}

	public static void adicionaRotaArquivo() throws Throwable, FileNotFoundException, Exception, IOException {
		BufferedReader br = null;
		String linha = null;
		br = new BufferedReader(new FileReader("input-file.csv"));
		try {
			while ((linha = br.readLine()) != null) {
				String[] rotaArquivo = linha.split(",");
				rotas.add(new Rota(chave++, rotaArquivo[rotaArquivo.length - 3], rotaArquivo[rotaArquivo.length - 2],
						rotaArquivo[rotaArquivo.length - 1]));
//				System.out.println("País [code= " + rotaArquivo[rotaArquivo.length - 3] + " name="
//						+ rotaArquivo[rotaArquivo.length - 2] + " , name=" + rotaArquivo[rotaArquivo.length - 1] + "]");
			}

			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
