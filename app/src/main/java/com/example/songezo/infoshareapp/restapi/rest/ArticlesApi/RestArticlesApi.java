package com.example.songezo.infoshareapp.restapi.rest.ArticlesApi;

import com.example.songezo.infoshareapp.domain.Articles;
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
public class RestArticlesApi implements RestAPI<Articles,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Articles get(Long id) {
        final String url = BASE_URL+"articles/"+id.toString();
        HttpEntity<Articles> requestEntity = new HttpEntity<Articles>(requestHeaders);
        ResponseEntity<Articles> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Articles.class);
        Articles articles = responseEntity.getBody();
        return articles;
    }

    @Override
    public String post(Articles entity) {
        final String url = BASE_URL+"articles/create";
        HttpEntity<Articles> requestEntity = new HttpEntity<Articles>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Articles entity) {
        final String url = BASE_URL+"articles/update/"+entity.getId().toString();
        HttpEntity<Articles> requestEntity = new HttpEntity<Articles>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Articles entity) {
        final String url = BASE_URL+"articles/delete/"+entity.getId().toString();
        HttpEntity<Articles> requestEntity = new HttpEntity<Articles>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Articles> getAll() {
        List<Articles> articlesList = new ArrayList<>();
        final String url = BASE_URL+"articles/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Articles[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Articles[].class);
        Articles[] results = responseEntity.getBody();

        for (Articles articles : results) {
            articlesList.add(articles);
        }
        return articlesList;
    }
}
