package com.example.songezo.infoshareapp.restapi.rest.shareStoriesAPI;

import com.example.songezo.infoshareapp.domain.ShareStories;
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

public class RestShareStoriesAPI implements RestAPI<ShareStories,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public ShareStories get(Long id) {
        final String url = BASE_URL+"stories/"+id.toString();
        HttpEntity<ShareStories> requestEntity = new HttpEntity<ShareStories>(requestHeaders);
        ResponseEntity<ShareStories> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ShareStories.class);
        ShareStories stories = responseEntity.getBody();
        return stories;
    }

    @Override
    public String post(ShareStories entity) {
        final String url = BASE_URL+"stories/create";
        HttpEntity<ShareStories> requestEntity = new HttpEntity<ShareStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(ShareStories entity) {
        final String url = BASE_URL+"stories/update/"+entity.getId().toString();
        HttpEntity<ShareStories> requestEntity = new HttpEntity<ShareStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(ShareStories entity) {
        final String url = BASE_URL+"stories/delete/"+entity.getId().toString();
        HttpEntity<ShareStories> requestEntity = new HttpEntity<ShareStories>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<ShareStories> getAll() {
        List<ShareStories> storiesList = new ArrayList<>();
        final String url = BASE_URL+"storiess/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<ShareStories[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ShareStories[].class);
        ShareStories[] results = responseEntity.getBody();

        for (ShareStories stories : results) {
            storiesList.add(stories);
        }
        return storiesList;
    }
}

