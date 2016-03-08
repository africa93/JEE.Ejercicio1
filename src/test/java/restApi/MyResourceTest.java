package restApi;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import config.TestsApiConfig;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestsApiConfig.class})
public class MyResourceTest {

	private static final String URL_API = "http://localhost:8080/Ejercicio1.0.0.1-SNAPSHOT";
	@Test
	public void testEcho() {
		HttpHeaders headers = new HttpHeaders();

		MultiValueMap<String, String> params = new HttpHeaders();
		params.add("dividendo", "6");
		params.add("divisor", "2");


		URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMIN).path(Uris.DIVISION).queryParams(params)
				.buildAndExpand().encode().toUri();
		System.out.println("URI: " + uri);
		RequestEntity<Object> requestEntity = new RequestEntity<>(headers, HttpMethod.GET, uri);
		double response = new RestTemplate().exchange(requestEntity, Double.class).getBody();
		System.out.println("Response: " + response);
		assertTrue(response == 3.0);
	}

	@Test
	public void testBody(){
		URI uri = UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMIN).path(Uris.CALCULADORA2)
				.buildAndExpand().encode().toUri();
		Fraccion fraccion = new Fraccion(6, 3);
		RequestEntity<Fraccion> requestEntity = new RequestEntity<>(fraccion, HttpMethod.POST, uri);
		String json = new RestTemplate().exchange(requestEntity, String.class).getBody();
		System.out.println(json);
		Double response = new RestTemplate().exchange(requestEntity, Double.class).getBody();
		System.out.println(response);
		assertTrue(response==2.0);
	}

	@Test 
	public void testBodyDoubleList(){
		URI uri =  UriComponentsBuilder.fromHttpUrl(URL_API).path(Uris.ADMIN).path(Uris.CALCULADORA3).build().encode().toUri();
		Fraccion fraccion = new Fraccion(6, 3);
		Fraccion fraccion2 = new Fraccion(6, 3);
		Fraccion fraccion3 = new Fraccion(6, 3);
		RequestEntity<List<Fraccion>> requestEntity = new RequestEntity<>(Arrays.asList(fraccion, fraccion2, fraccion3), HttpMethod.POST, uri);
		List<Double> response = Arrays.asList(new RestTemplate().exchange(requestEntity, Double[].class).getBody());
		System.out.println(response);
	}

	@Test
	public void testErrorNotFoundUserIdException(){
		try{
			new RestBuilder<Double>(URL_API).path(Uris.ADMINS).path(Uris.ERRORES).param("dividendo","-1").param("divisor", "2").get().build();
			fail();
		}catch(HttpClientErrorException httpError){
			assertEquals(HttpStatus.NOT_FOUND, httpError.getStatusCode());
			System.out.println("ERROR >>>>> " + httpError.getMessage());
			System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
		}
	}
	@Test
	public void testErrorMalformedHeaderException(){
		try{
			new RestBuilder<Double>(URL_API).path(Uris.ADMINS).path(Uris.ERRORES).param("dividendo","2").param("divisor", "-3").get().build();
			fail();
		}catch(HttpClientErrorException httpError){
			assertEquals(HttpStatus.BAD_REQUEST, httpError.getStatusCode());
			System.out.println("ERROR >>>>> " + httpError.getMessage());
			System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
		}
	}

	@Test
	public void testErrorUnauthorizedException(){
		try{
			new RestBuilder<Double>(URL_API).path(Uris.ADMINS).path(Uris.ERRORES).param("dividendo","1").param("divisor", "2").get().build();
			fail();
		}catch(HttpClientErrorException httpError){
			assertEquals(HttpStatus.UNAUTHORIZED, httpError.getStatusCode());
			System.out.println("ERROR >>>>> " + httpError.getMessage());
			System.out.println("ERROR >>>>> " + httpError.getResponseBodyAsString());
		}
	}


}
