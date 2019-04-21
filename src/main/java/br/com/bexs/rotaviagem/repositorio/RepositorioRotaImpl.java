package br.com.bexs.rotaviagem.repositorio;

import java.io.File;
import java.rmi.registry.Registry;

import br.com.bexs.rotaviagem.dominio.Rota;
import br.com.bexs.rotaviagem.utilitarios.Registro;

public class RepositorioRotaImpl implements RepositorioRota{
private File arquivoDeRota = Registro.getDatabaseFile();
	@Override
	public boolean inserirRota(Rota rota) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Rota obterMelhorRota(Rota rota) {
		// TODO Auto-generated method stub
		return null;
	}

}
