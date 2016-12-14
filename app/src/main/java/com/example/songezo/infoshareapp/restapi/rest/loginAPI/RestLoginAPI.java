package com.example.songezo.infoshareapp.restapi.rest.loginAPI;

import com.example.songezo.infoshareapp.domain.Login;
import com.example.songezo.infoshareapp.restapi.RestAPI;
import com.example.songezo.infoshareapp.restapi.rest.RestMethods;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiphe.dyani on 2016/12/14.
 */

public class RestLoginAPI implements RestAPI<Login,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Login get(Long id) {
        final String url = BASE_URL+"login/"+id.toString();
        HttpEntity<Login> requestEntity = new HttpEntity<Login>(requestHeaders);
        ResponseEntity<Login> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Login.class);
        Login login = responseEntity.getBody();
        return login;
    }

    @Override
    public String post(Login entity) {
        final String url = BASE_URL+"login/create";
        HttpEntity<Login> requestEntity = new HttpEntity<Login>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Login entity) {
        final String url = BASE_URL+"login/update/"+entity.getId().toString();
        HttpEntity<Login> requestEntity = new HttpEntity<Login>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Login entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<Login> requestEntity = new HttpEntity<Login>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Login> getAll() {
        List<Login> loginList = new ArrayList<>();
        final String url = BASE_URL+"logins/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Login[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Login[].class);
        Login[] results = responseEntity.getBody();

        for (Login login : results) {
            loginList.add(login);
        }
        return loginList;
    }


}
