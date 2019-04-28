package br.com.bexs.rotaviagem.repositorio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.bexs.rotaviagem.dominio.Rota;
import br.com.bexs.rotaviagem.utilitarios.Registro;

@Repository
public class RepositorioRotaImpl implements RepositorioRota{
	
private File arquivoDeRota = Registro.getDatabaseFile();
	@Override
	public boolean inserirRota(Rota rota) {
		boolean saved = false;

		try {
			if (!containsRoute(rota)) {
				Files.write(Paths.get(arquivoDeRota.getAbsolutePath()), rota.complementoDeInformacao().getBytes(), 
						StandardOpenOption.APPEND);				
			}
			saved = true;
		} catch (Exception e) {
			saved = false;
			e.printStackTrace();
		}

		return saved;
	}

	@Override
	public Rota obterMelhorRota(Rota rota) {
		return obterRotaFromSourceFile().stream().sorted(Comparator.comparing(Rota::obterValor))
				.filter(routeFound -> 
							routeFound.obterSaida().equals(rota.obterSaida()) && routeFound.obterDestino().equals(rota.obterDestino()))
				.findFirst().orElse(null);
	}
	
	private List<Rota> obterRotaFromSourceFile() {
		List<Rota> rotas = new ArrayList<>();

		try {
			List<String> routesString = Files.readAllLines(Paths.get(arquivoDeRota.getAbsolutePath()));

			routesString.stream().forEach(newRoute -> {
				rotas.add(new Rota(newRoute));
			});

		} catch (IOException e) {
			e.printStackTrace();
		}

		return rotas;
	}
	
	

	private boolean containsRoute(Rota rota) {
		return obterRotaFromSourceFile().contains(rota);
	}
	
}
