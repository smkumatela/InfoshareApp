package com.example.songezo.infoshareapp.restapi.rest.Event_CalenderAPI;

import com.example.songezo.infoshareapp.domain.Event_Calender;
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

public class RestEvent_CalenderAPI implements RestAPI<Event_Calender,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Event_Calender get(Long id) {
        final String url = BASE_URL+"event_Calender/"+id.toString();
        HttpEntity<Event_Calender> requestEntity = new HttpEntity<Event_Calender>(requestHeaders);
        ResponseEntity<Event_Calender> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Event_Calender.class);
        Event_Calender event_Calender = responseEntity.getBody();
        return event_Calender;
    }

    @Override
    public String post(Event_Calender entity) {
        final String url = BASE_URL+"event_Calender/create";
        HttpEntity<Event_Calender> requestEntity = new HttpEntity<Event_Calender>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Event_Calender entity) {
        final String url = BASE_URL+"event_Calender/update/"+entity.getId().toString();
        HttpEntity<Event_Calender> requestEntity = new HttpEntity<Event_Calender>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Event_Calender entity) {
        final String url = BASE_URL+"event_Calender/delete/"+entity.getId().toString();
        HttpEntity<Event_Calender> requestEntity = new HttpEntity<Event_Calender>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Event_Calender> getAll() {
        List<Event_Calender> event_CalenderList = new ArrayList<>();
        final String url = BASE_URL+"event_Calender/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Event_Calender[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Event_Calender[].class);
        Event_Calender[] results = responseEntity.getBody();

        for (Event_Calender event_Calender : results) {
            event_CalenderList.add(event_Calender);
        }
        return event_CalenderList;
    }
}