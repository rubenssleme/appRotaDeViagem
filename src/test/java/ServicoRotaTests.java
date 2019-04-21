

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;

import br.com.bexs.rotaviagem.dto.ResultadoBuscaRotaDTO;
import br.com.bexs.rotaviagem.dto.ResultadoEdicaoRotaDTO;
import br.com.bexs.rotaviagem.dto.RotaDTO;
import br.com.bexs.rotaviagem.servico.rest.RestContrato;
import br.com.bexs.rotaviagem.utilitarios.HttpUtils;



@SpringBootTest
public class ServicoRotaTests {

	private TestRestTemplate restTemplate;

	public ServicoRotaTests() {
		restTemplate = new TestRestTemplate();
	}

	private String getSaveRouteUrl() {
		return RestContrato.URL_BASE + RestContrato.URL_ROTAS;
	}

	private String getFetchBestRouteUrl(String informacaoRota) {
		return RestContrato.URL_BASE
				+ RestContrato.URL_OBTER_MELHOR_ROTA.replace(RestContrato.PARAMETRO_INFO_ROTA, informacaoRota);
	}

	@Test
	public void given_a_client_when_fetching_best_route_passing_valid_info_route_then_returns_success() {
		String informacaoRota = "GRU-BRC";

		ResultadoBuscaRotaDTO resultadoBuscaRotaDTO = restTemplate
				.getForEntity(getFetchBestRouteUrl(informacaoRota), ResultadoBuscaRotaDTO.class).getBody();

		Assert.assertNotNull(resultadoBuscaRotaDTO.getBestRoute());
	}

	@Test
	public void given_a_client_when_fetching_best_route_passing_invalid_info_route_then_returns_error() {
		String informacaoRota = ",,,,";

		ResultadoBuscaRotaDTO resultadoBuscaRotaDTO = restTemplate
				.getForEntity(getFetchBestRouteUrl(informacaoRota), ResultadoBuscaRotaDTO.class).getBody();

		Assert.assertNotNull(resultadoBuscaRotaDTO.getBestRoute());
	}

	@Test
	public void given_a_client_when_saving_new_route_passing_valid_info_route_then_returns_success() {
		String informacaoRota = "GRU,BRC,CDG,15";

		RotaDTO novaRotaDTO = new RotaDTO();

		novaRotaDTO.atribuirInformacaoRota(informacaoRota);

		ResultadoEdicaoRotaDTO resultadoEdicaoRotaDTO = restTemplate
				.postForEntity(getSaveRouteUrl(), HttpUtils.criar(novaRotaDTO), ResultadoEdicaoRotaDTO.class).getBody();

		Assert.assertTrue(resultadoEdicaoRotaDTO.isSuccess());
	}

	@Test
	public void given_a_client_when_saving_new_route_passing_invalid_info_route_then_returns_success() {
		RotaDTO novaRotaDTO = new RotaDTO();

		novaRotaDTO.atribuirInformacaoRota(null);

		ResultadoEdicaoRotaDTO resultadoEdicaoRotaDTO = restTemplate
				.postForEntity(getSaveRouteUrl(), HttpUtils.criar(novaRotaDTO), ResultadoEdicaoRotaDTO.class).getBody();

		Assert.assertFalse(resultadoEdicaoRotaDTO.isSuccess());
	}
}
