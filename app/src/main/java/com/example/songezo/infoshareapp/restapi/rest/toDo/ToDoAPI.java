package com.example.songezo.infoshareapp.restapi.rest.toDo;

import com.example.songezo.infoshareapp.domain.ToDo;
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
public class ToDoAPI implements RestAPI<ToDo, Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public ToDo get(Long aLong) {
        final String url = BASE_URL+"toDo/"+aLong.toString();
        HttpEntity<ToDo> requestEntity = new HttpEntity<ToDo>(requestHeaders);
        ResponseEntity<ToDo> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ToDo.class);
        ToDo toDo = responseEntity.getBody();
        return toDo;
    }

    @Override
    public String post(ToDo entity) {
        final String url = BASE_URL+"toDo/create";
        HttpEntity<ToDo> requestEntity = new HttpEntity<ToDo>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(ToDo entity) {
        final String url = BASE_URL+"toDo/update/"+entity.getId();
        HttpEntity<ToDo> requestEntity = new HttpEntity<ToDo>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(ToDo entity) {
        final String url = BASE_URL+"toDo/delete/"+entity.getId();
        HttpEntity<ToDo> requestEntity = new HttpEntity<ToDo>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<ToDo> getAll() {
        List<ToDo> toDoList = new ArrayList<>();
        final String url = BASE_URL+"toDo/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<ToDo[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ToDo[].class);
        ToDo[] results = responseEntity.getBody();

        for (ToDo toDo : results) {
            toDoList.add(toDo);
        }
        return toDoList;
    }
}
