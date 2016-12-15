package com.example.songezo.infoshareapp.restapi.rest.Suggestion_BoxAPI;

import com.example.songezo.infoshareapp.domain.Suggestion_Box;
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
 * Created by Mandisi on 12/15/2016.
 */

public class RestSuggestion_BoxAPI implements RestAPI<Suggestion_Box,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Suggestion_Box get(Long id) {
        final String url = BASE_URL+"suggestion_Box/"+id.toString();
        HttpEntity<Suggestion_Box> requestEntity = new HttpEntity<Suggestion_Box>(requestHeaders);
        ResponseEntity<Suggestion_Box> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Suggestion_Box.class);
        Suggestion_Box suggestion_Box = responseEntity.getBody();
        return suggestion_Box;
    }

    @Override
    public String post(Suggestion_Box entity) {
        final String url = BASE_URL+"suggestion_Box/create";
        HttpEntity<Suggestion_Box> requestEntity = new HttpEntity<Suggestion_Box>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Suggestion_Box entity) {
        final String url = BASE_URL+"suggestion_Box/update/"+entity.getId().toString();
        HttpEntity<Suggestion_Box> requestEntity = new HttpEntity<Suggestion_Box>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Suggestion_Box entity) {
        final String url = BASE_URL+"suggestion_Box/delete/"+entity.getId().toString();
        HttpEntity<Suggestion_Box> requestEntity = new HttpEntity<Suggestion_Box>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Suggestion_Box> getAll() {
        List<Suggestion_Box> suggestion_BoxList = new ArrayList<>();
        final String url = BASE_URL+"suggestion_Box/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Suggestion_Box[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Suggestion_Box[].class);
        Suggestion_Box[] results = responseEntity.getBody();

        for (Suggestion_Box suggestion_Box : results) {
            suggestion_BoxList.add(suggestion_Box);
        }
        return suggestion_BoxList;
    }
}
