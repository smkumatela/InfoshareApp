package com.example.songezo.infoshareapp.restapi.rest.VideoApi;

import com.example.songezo.infoshareapp.domain.Video;
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
public class RestVideoApi implements RestAPI<Video,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Video get(Long id) {
        final String url = BASE_URL+"video/"+id.toString();
        HttpEntity<Video> requestEntity = new HttpEntity<Video>(requestHeaders);
        ResponseEntity<Video> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Video.class);
        Video video = responseEntity.getBody();
        return video;
    }

    @Override
    public String post(Video entity) {
        final String url = BASE_URL+"video/create";
        HttpEntity<Video> requestEntity = new HttpEntity<Video>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Video entity) {
        final String url = BASE_URL+"video/update/"+entity.getId().toString();
        HttpEntity<Video> requestEntity = new HttpEntity<Video>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Video entity) {
        final String url = BASE_URL+"video/delete/"+entity.getId().toString();
        HttpEntity<Video> requestEntity = new HttpEntity<Video>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Video> getAll() {
        List<Video> videoList = new ArrayList<>();
        final String url = BASE_URL+"video/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Video[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Video[].class);
        Video[] results = responseEntity.getBody();

        for (Video video : results) {
            videoList.add(video);
        }
        return videoList;
    }
}
