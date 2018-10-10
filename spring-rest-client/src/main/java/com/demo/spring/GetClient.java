package com.demo.spring;

import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetClient {
	public static void main(String[] args) {
		
		String userDetails = "shantanu:welcome";
		String encodedCred = new String(Base64.encodeBase64(userDetails.getBytes()));
		
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "application/json");
		headers.set("Authorization", "Basic "+encodedCred);
		
		HttpEntity req = new HttpEntity<>(headers);
		
		ResponseEntity<Employee> resp = rt.exchange("http://localhost:8081/emp/105", HttpMethod.GET,req,Employee.class);
		
		System.out.println(resp.getBody());
		
		ResponseEntity<List<Employee>> resp1 = rt.exchange("http://localhost:8081/emp/list",HttpMethod.GET,req, new ParameterizedTypeReference<List<Employee>>() {
			
		});
		
		resp1.getBody().stream().forEach(e->System.out.println(e.toString()));
	}
}
