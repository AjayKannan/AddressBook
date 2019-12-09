package com.moo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * Class to test basic aut for API is enabled
 * 
 * @author Ajay
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthTest {

	@Autowired
	private TestRestTemplate template;


	@WithMockUser("spring")
	@Test
	public void testAddressUnAuthorized() throws Exception {

		ResponseEntity<String> result = template.withBasicAuth("spring", "secret").getForEntity("/v1/contact/1/address",
				String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
	}
	
	@WithMockUser("spring")
	@Test
	public void testAddressAuthorized() throws Exception {

		ResponseEntity<String> result = template.withBasicAuth("user", "user").getForEntity("/v1/contact/1/address",
				String.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
	
	
	@WithMockUser("spring")
	@Test
	public void testContactUnAuthorized() throws Exception {

		ResponseEntity<String> result = template.withBasicAuth("spring", "secret").getForEntity("/v1/contact?surname=major",
				String.class);

		assertEquals(HttpStatus.UNAUTHORIZED, result.getStatusCode());
	}
	
	@WithMockUser("spring")
	@Test
	public void testContactAuthorized() throws Exception {

		ResponseEntity<String> result = template.withBasicAuth("user", "user").getForEntity("/v1/contact?surname=major",
				String.class);

		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
