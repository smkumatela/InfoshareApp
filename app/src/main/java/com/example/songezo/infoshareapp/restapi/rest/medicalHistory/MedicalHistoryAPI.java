package com.example.songezo.infoshareapp.restapi.rest.medicalHistory;

import com.example.songezo.infoshareapp.domain.MedicalHistory;
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
public class MedicalHistoryAPI implements RestAPI<MedicalHistory, Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public MedicalHistory get(Long aLong) {
        final String url = BASE_URL+"medicalHistory/"+aLong.toString();
        HttpEntity<MedicalHistory> requestEntity = new HttpEntity<MedicalHistory>(requestHeaders);
        ResponseEntity<MedicalHistory> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MedicalHistory.class);
        MedicalHistory medicalHistory = responseEntity.getBody();
        return medicalHistory;
    }

    @Override
    public String post(MedicalHistory entity) {
        final String url = BASE_URL+"medicalHistory/create";
        HttpEntity<MedicalHistory> requestEntity = new HttpEntity<MedicalHistory>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(MedicalHistory entity) {
        final String url = BASE_URL+"medicalHistory/update/"+entity.getId();
        HttpEntity<MedicalHistory> requestEntity = new HttpEntity<MedicalHistory>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(MedicalHistory entity) {
        final String url = BASE_URL+"medicalHistory/delete/"+entity.getId();
        HttpEntity<MedicalHistory> requestEntity = new HttpEntity<MedicalHistory>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<MedicalHistory> getAll() {
        List<MedicalHistory> medicalHistoryList = new ArrayList<>();
        final String url = BASE_URL+"organisations/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<MedicalHistory[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MedicalHistory[].class);
        MedicalHistory[] results = responseEntity.getBody();

        for (MedicalHistory medicalHistory : results) {
            medicalHistoryList.add(medicalHistory);
        }
        return medicalHistoryList;
    }
}
