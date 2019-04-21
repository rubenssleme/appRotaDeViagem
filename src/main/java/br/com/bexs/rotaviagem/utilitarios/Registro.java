package br.com.bexs.rotaviagem.utilitarios;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import br.com.bexs.rotaviagem.Aplicacao;

public class Registro {
	private static ApplicationContext context;
	private static File arquivoDeRota = new File("db", "database.csv");
	
	public static void initializeContext() {
		if (context == null) {
			context = (ApplicationContext) new SpringApplication(Aplicacao.class).run();
		}
	}

	public static void setContext(ApplicationContext context) {
		Registro.context = context;
	}

	public static void closeContext() {
		((AbstractApplicationContext) context).close();
	}
	
	public static void changeDatabaseFile(String databaseFilePath) {
		arquivoDeRota = new File(databaseFilePath);
	}
	
	public static void restoreDatabaseFile() {
		arquivoDeRota = new File("db", "database.csv");
	}
	
	public static File getDatabaseFile() {
		return arquivoDeRota;
	}

}