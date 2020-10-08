package com.oct.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class DummyController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/dummy")
    public String findAll() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> dummy =new HttpEntity<String>(headers);

        return restTemplate.exchange("http://dummy.restapiexample.com/api/v1/employees", HttpMethod.GET,
                dummy, String.class).getBody();
    }
}
