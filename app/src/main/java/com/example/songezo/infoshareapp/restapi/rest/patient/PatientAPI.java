package com.example.songezo.infoshareapp.restapi.rest.patient;

import com.example.songezo.infoshareapp.domain.Patient;
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
public class PatientAPI implements RestAPI<Patient,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Patient get(Long aLong) {
        final String url = BASE_URL+"patient/"+aLong.toString();
        HttpEntity<Patient> requestEntity = new HttpEntity<Patient>(requestHeaders);
        ResponseEntity<Patient> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Patient.class);
        Patient patient = responseEntity.getBody();
        return patient;
    }

    @Override
    public String post(Patient entity) {
        final String url = BASE_URL+"patient/create";
        HttpEntity<Patient> requestEntity = new HttpEntity<Patient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Patient entity) {
        final String url = BASE_URL+"patient/update/"+entity.getId();
        HttpEntity<Patient> requestEntity = new HttpEntity<Patient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Patient entity) {
        final String url = BASE_URL+"patient/delete/"+entity.getId();
        HttpEntity<Patient> requestEntity = new HttpEntity<Patient>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patientList = new ArrayList<>();
        final String url = BASE_URL+"patient/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Patient[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Patient[].class);
        Patient[] results = responseEntity.getBody();

        for (Patient patient : results) {
            patientList.add(patient);
        }
        return patientList;
    }

}
