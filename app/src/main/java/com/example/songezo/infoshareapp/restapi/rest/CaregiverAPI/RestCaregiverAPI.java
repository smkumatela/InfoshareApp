package com.example.songezo.infoshareapp.restapi.rest.CaregiverAPI;

import com.example.songezo.infoshareapp.domain.Caregiver;
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

public class RestCaregiverAPI implements RestAPI<Caregiver,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Caregiver get(Long id) {
        final String url = BASE_URL+"seeStories/"+id.toString();
        HttpEntity<Caregiver> requestEntity = new HttpEntity<Caregiver>(requestHeaders);
        ResponseEntity<Caregiver> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Caregiver.class);
        Caregiver caregiver = responseEntity.getBody();
        return caregiver;
    }

    @Override
    public String post(Caregiver entity) {
        final String url = BASE_URL+"caregiver/create";
        HttpEntity<Caregiver> requestEntity = new HttpEntity<Caregiver>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Caregiver entity) {
        final String url = BASE_URL+"caregiver/update/"+entity.getId().toString();
        HttpEntity<Caregiver> requestEntity = new HttpEntity<Caregiver>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Caregiver entity) {
        final String url = BASE_URL+"caregiver/delete/"+entity.getId().toString();
        HttpEntity<Caregiver> requestEntity = new HttpEntity<Caregiver>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Caregiver> getAll() {
        List<Caregiver> caregiverList = new ArrayList<>();
        final String url = BASE_URL+"caregiver/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Caregiver[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Caregiver[].class);
        Caregiver[] results = responseEntity.getBody();

        for (Caregiver caregiver : results) {
            caregiverList.add(caregiver);
        }
        return caregiverList;
    }
}