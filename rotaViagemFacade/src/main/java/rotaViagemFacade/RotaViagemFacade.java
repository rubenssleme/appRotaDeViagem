package rotaViagemFacade;

import br.com.bexs.rotaviagem.PersistirNovaRota;

public class RotaViagemFacade {
	
	private String path;
	private String novaRota;
	
	PersistirNovaRota gravarRota = new PersistirNovaRota();
	
	

	public void obtemMelhorRota() {

	}

	public void adcionaRotaNova() {
		gravarRota.gravarNovaRota(path, novaRota);
	}

}
