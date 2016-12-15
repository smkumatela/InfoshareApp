package com.example.songezo.infoshareapp.restapi.rest.AudioApi;

import com.example.songezo.infoshareapp.domain.Audio;
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
public class RestAudioApi implements RestAPI<Audio,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Audio get(Long id) {
        final String url = BASE_URL+"audio/"+id.toString();
        HttpEntity<Audio> requestEntity = new HttpEntity<Audio>(requestHeaders);
        ResponseEntity<Audio> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Audio.class);
        Audio audio = responseEntity.getBody();
        return audio;
    }

    @Override
    public String post(Audio entity) {
        final String url = BASE_URL+"audio/create";
        HttpEntity<Audio> requestEntity = new HttpEntity<Audio>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Audio entity) {
        final String url = BASE_URL+"audio/update/"+entity.getId().toString();
        HttpEntity<Audio> requestEntity = new HttpEntity<Audio>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Audio entity) {
        final String url = BASE_URL+"audio/delete/"+entity.getId().toString();
        HttpEntity<Audio> requestEntity = new HttpEntity<Audio>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Audio> getAll() {
        List<Audio> audioList = new ArrayList<>();
        final String url = BASE_URL+"audio/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Audio[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Audio[].class);
        Audio[] results = responseEntity.getBody();

        for (Audio audio : results) {
            audioList.add(audio);
        }
        return audioList;
    }
}
