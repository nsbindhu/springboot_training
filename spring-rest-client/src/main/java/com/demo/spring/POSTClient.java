package com.demo.spring;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class POSTClient {
	public static void main(String[] args) {
		
		RestTemplate rt = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", "text/plain");
		headers.set("Content-Type", "application/json");
		
		Employee e = new Employee(109,"Sandeep","Vikarabad",40000);
		HttpEntity req = new HttpEntity<>(e,headers);
		
		ResponseEntity<String> resp = rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST,req,String.class);
		
		System.out.println(resp.getBody());
		
	}
}
