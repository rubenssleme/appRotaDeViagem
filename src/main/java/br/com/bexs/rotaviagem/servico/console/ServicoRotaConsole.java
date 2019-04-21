package br.com.bexs.rotaviagem.servico.console;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.bexs.rotaviagem.dto.ResultadoBuscaRotaDTO;
import br.com.bexs.rotaviagem.dto.RotaDTO;
import br.com.bexs.rotaviagem.servico.rest.ServicoRota;
import br.com.bexs.rotaviagem.utilitarios.Registro;

@Component
public class ServicoRotaConsole implements CommandLineRunner {
	@Autowired
	private ServicoRota servicoRota;

	@Override
	public void run(String... args) {
		for (String arg: args) {
			System.out.println(arg);
		}
		
		if (args.length > 0) {
			Scanner input = new Scanner(System.in);
			int option = 0;

			do {
				Registro.changeDatabaseFile(args[0]);

				System.out.println("please enter the route");
				String rota = input.next();

				ResultadoBuscaRotaDTO resultadoBuscaRotaDto = servicoRota.fetchBestRoute(new RotaDTO(rota));

				if (resultadoBuscaRotaDto.isSuccess()) {
					System.out.println(resultadoBuscaRotaDto.getBestRoute());
				} else {
					System.out.println(resultadoBuscaRotaDto.getErros());
				}

				System.out.println("1 - Continue\n2 - Stop");
				option = input.nextInt();
			} while (option != 2);

			input.close();
		} else {
			Registro.restoreDatabaseFile();
		}
	}
}
