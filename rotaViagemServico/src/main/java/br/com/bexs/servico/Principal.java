package br.com.bexs.servico;

public class Principal {
	public static void main(String[] args) {

		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "input-routes.csv": {
				System.out.println("Rotas carregadas..\n" + "Entre com a rota desejada:<saida-destino>Ex.: GRU-CGD");
				break;
			}
			default : {
				String s = args[i].toString();
				System.out.println("\nRota digitada: " + s);
				
				System.out.println("\nEntre com a proxima rota desejada:<saida-destino> Ex.: GRU-CGD");
				break;
			}

			}

		}
	}
}
