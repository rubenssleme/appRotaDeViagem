package br.com.bexs.rotaviagem.servico.rest;

public class RestContrato {
	public static final String PARAMETRO_INFO_ROTA = "informacaoRota";
	public static final String URL_PARAMETRO_INFOROTA = "{" + PARAMETRO_INFO_ROTA + "}";

	public static final String URL_BASE = "http://localhost:8080";
	
	public static final String URL_ROTAS = "/rota";
	public static final String URL_OBTER_MELHOR_ROTA = URL_ROTAS + "/melhor-rota/" + URL_PARAMETRO_INFOROTA;

}
