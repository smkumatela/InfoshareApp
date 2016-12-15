package com.example.songezo.infoshareapp.restapi.rest.AboutApi;

import com.example.songezo.infoshareapp.domain.About;
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
 * Created by VERNON on 2016/12/15.
 */
public class RestAboutApi implements RestAPI<About,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public About get(Long id) {
        final String url = BASE_URL+"about/"+id.toString();
        HttpEntity<About> requestEntity = new HttpEntity<About>(requestHeaders);
        ResponseEntity<About> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, About.class);
        About about = responseEntity.getBody();
        return about;
    }

    @Override
    public String post(About entity) {
        final String url = BASE_URL+"about/create";
        HttpEntity<About> requestEntity = new HttpEntity<About>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(About entity) {
        final String url = BASE_URL+"about/update/"+entity.getId().toString();
        HttpEntity<About> requestEntity = new HttpEntity<About>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(About entity) {
        final String url = BASE_URL+"login/delete/"+entity.getId().toString();
        HttpEntity<About> requestEntity = new HttpEntity<About>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<About> getAll() {
        List<About> aboutList = new ArrayList<>();
        final String url = BASE_URL+"about/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<About[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, About[].class);
        About[] results = responseEntity.getBody();

        for (About about : results) {
            aboutList.add(about);
        }
        return aboutList;
    }
}
