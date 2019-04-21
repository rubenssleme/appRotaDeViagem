package br.com.bexs.rotaviagem.repositorio;

import br.com.bexs.rotaviagem.dominio.Rota;

public interface RepositorioRota {
	public boolean inserirRota(Rota rota);
	public Rota obterMelhorRota(Rota rota);
}
