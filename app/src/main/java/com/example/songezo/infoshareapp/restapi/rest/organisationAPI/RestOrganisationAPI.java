package com.example.songezo.infoshareapp.restapi.rest.organisationAPI;

import com.example.songezo.infoshareapp.domain.Organisation;
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

public class RestOrganisationAPI implements RestAPI<Organisation,Long> {


    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Organisation get(Long id) {
        final String url = BASE_URL+"organisation/"+id.toString();
        HttpEntity<Organisation> requestEntity = new HttpEntity<Organisation>(requestHeaders);
        ResponseEntity<Organisation> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Organisation.class);
        Organisation organisation = responseEntity.getBody();
        return organisation;
    }

    @Override
    public String post(Organisation entity) {
        final String url = BASE_URL+"organisation/create";
        HttpEntity<Organisation> requestEntity = new HttpEntity<Organisation>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Organisation entity) {
        final String url = BASE_URL+"organisation/update/"+entity.getId().toString();
        HttpEntity<Organisation> requestEntity = new HttpEntity<Organisation>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Organisation entity) {
        final String url = BASE_URL+"organisation/delete/"+entity.getId().toString();
        HttpEntity<Organisation> requestEntity = new HttpEntity<Organisation>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Organisation> getAll() {
        List<Organisation> organisationList = new ArrayList<>();
        final String url = BASE_URL+"organisations/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Organisation[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Organisation[].class);
        Organisation[] results = responseEntity.getBody();

        for (Organisation organisation : results) {
            organisationList.add(organisation);
        }
        return organisationList;
    }
}
