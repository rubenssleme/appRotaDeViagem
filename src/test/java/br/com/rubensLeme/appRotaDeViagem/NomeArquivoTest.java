package br.com.rubensLeme.appRotaDeViagem;

import org.junit.Assert;
import org.junit.Test;


public class NomeArquivoTest {
	

	@Test
	public void test() {
	GravarRotasNovas grv = new GravarRotasNovas();
	
	grv.escrever(grv.atribuirBarrasAoArquivo()+"input-file.csv", "DDD-RRR3");
	
	}
	
	@Test
	public void atribuir_barras_ao_caminho_do_diretorio() {
	GravarRotasNovas grv = new GravarRotasNovas();
	grv.atribuirBarrasAoArquivo();
	Assert.assertEquals(System.getProperty("user.dir"), grv.atribuirBarrasAoArquivo());
	
	}
	@Test
	public void dado_um_texto_invalido_quando_o_formatador_validar_as_linhas_de_entrada_e_formato_retornar_os_erros_esperados() {
		GravarRotasNovas grv = new GravarRotasNovas();
		grv.atribuirBarrasAoArquivo();
		Assert.assertEquals(System.getProperty("user.dir")+"\\", grv.atribuirBarrasAoArquivo());
	}

}
