package com.example.songezo.infoshareapp.restapi.rest.seeStoriesAPI;

import com.example.songezo.infoshareapp.domain.SeeStories;
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

public class RestSeeStoriesAPI implements RestAPI<SeeStories,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public SeeStories get(Long id) {
        final String url = BASE_URL+"seeStories/"+id.toString();
        HttpEntity<SeeStories> requestEntity = new HttpEntity<SeeStories>(requestHeaders);
        ResponseEntity<SeeStories> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, SeeStories.class);
        SeeStories seeStories = responseEntity.getBody();
        return seeStories;
    }

    @Override
    public String post(SeeStories entity) {
        final String url = BASE_URL+"seeStories/create";
        HttpEntity<SeeStories> requestEntity = new HttpEntity<SeeStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(SeeStories entity) {
        final String url = BASE_URL+"seeStories/update/"+entity.getId().toString();
        HttpEntity<SeeStories> requestEntity = new HttpEntity<SeeStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(SeeStories entity) {
        final String url = BASE_URL+"seeStories/delete/"+entity.getId().toString();
        HttpEntity<SeeStories> requestEntity = new HttpEntity<SeeStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<SeeStories> getAll() {
        List<SeeStories> seeStoriesList = new ArrayList<>();
        final String url = BASE_URL+"seeStoriess/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<SeeStories[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, SeeStories[].class);
        SeeStories[] results = responseEntity.getBody();

        for (SeeStories seeStories : results) {
            seeStoriesList.add(seeStories);
        }
        return seeStoriesList;
    }
}
