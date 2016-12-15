package com.example.songezo.infoshareapp.restapi.rest.myPatient;

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
 * Created by Songezo on 2016-12-15.
 */
public class MyPatient implements RestAPI<MyPatient, Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public MyPatient get(Long aLong) {
        final String url = BASE_URL+"myPatient/"+aLong.toString();
        HttpEntity<MyPatient> requestEntity = new HttpEntity<MyPatient>(requestHeaders);
        ResponseEntity<MyPatient> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MyPatient.class);
        MyPatient myPatient = responseEntity.getBody();
        return myPatient;
    }

    @Override
    public String post(MyPatient entity) {
        final String url = BASE_URL+"myPatient/create";
        HttpEntity<MyPatient> requestEntity = new HttpEntity<MyPatient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(MyPatient entity) {
        final String url = BASE_URL+"myPatient/update/"+entity.toString();
        HttpEntity<MyPatient> requestEntity = new HttpEntity<MyPatient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(MyPatient entity) {
        final String url = BASE_URL+"myPatient/delete/"+entity.toString();
        HttpEntity<MyPatient> requestEntity = new HttpEntity<MyPatient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<MyPatient> getAll() {
        List<MyPatient> myPatientList = new ArrayList<>();
        final String url = BASE_URL+"myPatient/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<MyPatient[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MyPatient[].class);
        MyPatient[] results = responseEntity.getBody();

        for (MyPatient myPatient : results) {
            myPatientList.add(myPatient);
        }
        return myPatientList;
    }
}
