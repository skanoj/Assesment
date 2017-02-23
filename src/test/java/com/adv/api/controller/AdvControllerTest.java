package com.adv.api.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.adv.api.domain.Campaign;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Integration test for 4 API calls of the Campaign API server.
 *
 * @author 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AdvControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;

	
	@Test
	public void testPostCampaign() {
		
		Campaign campaign = new Campaign("230",400,"Test ad");
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	
		 //this.restTemplate.postForEntity(url, request, responseType, urlVariables)
		ResponseEntity<String> response = this.restTemplate.exchange("/ad", HttpMethod.POST, entity, String.class);
				//.postForLocation("/ad", campaign, String.class, HttpHeaders.CONTENT_TYPE=String.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		System.out.println(response.getBody());
	}

	@Test
	public void testGetActiveCampaign() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/ad/{pId}", String.class,"200");
		assertThat(response.getStatusCode().is4xxClientError());
		System.out.println(response.getBody());
	}
	
	@Test
	public void testGetAllCampaigns() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/ad/camapign/all", String.class);
		assertThat(response.getStatusCode().is2xxSuccessful());
		System.out.println(response.getBody());
	}
	
	@Test
	public void testGetCampaignsOfPartner() {
		ResponseEntity<String> response = this.restTemplate.getForEntity("/ad/{pId}/all", String.class, "200");
		assertThat(response.getStatusCode().is4xxClientError());
		System.out.println(response.getBody());
	}

	
}
