package appRotaDeViagem;

public class TesteRoute {

	public static void main(String[] args) {

		for (int i = 0; i < args.length; i++) {
			switch (args[i]) {
			case "input-routes.csv": {
				System.out.println("Rotas carregadas..\n" + "Entre com a rota desejada:<saida-destino>Ex.: GRU-CGD");
				break;
			}
			case "-p": {
				System.out.println("Entre com a proxima rota desejada:<saida-destino> Ex.: GRU-CGD");
				break;
			}

			}

		}

	}
}