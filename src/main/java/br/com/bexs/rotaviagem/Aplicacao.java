package br.com.bexs.rotaviagem;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import br.com.bexs.rotaviagem.utilitarios.Registro;

@SpringBootApplication(scanBasePackages={
"br.com.bexs", "br.com.bexs.rotaviagem"})
public class Aplicacao implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	@PostConstruct
	public void inicializar() {
		Registro.setContext(context);
	}

	@Override
	public void run(String... args) throws Exception {
		Registro.initializeContext();
	}

	public static void main(String[] args) throws Exception {
		new SpringApplication(Aplicacao.class).run(args);
	}
}
