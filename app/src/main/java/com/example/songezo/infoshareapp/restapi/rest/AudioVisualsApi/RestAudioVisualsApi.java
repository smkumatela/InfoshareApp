package com.example.songezo.infoshareapp.restapi.rest.AudioVisualsApi;

import com.example.songezo.infoshareapp.domain.AudioVisuals;
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
public class RestAudioVisualsApi implements RestAPI<AudioVisuals,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public AudioVisuals get(Long id) {
        final String url = BASE_URL+"audioVisuals/"+id.toString();
        HttpEntity<AudioVisuals> requestEntity = new HttpEntity<AudioVisuals>(requestHeaders);
        ResponseEntity<AudioVisuals> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, AudioVisuals.class);
        AudioVisuals audioVisuals = responseEntity.getBody();
        return audioVisuals;
    }

    @Override
    public String post(AudioVisuals entity) {
        final String url = BASE_URL+"audioVisuals/create";
        HttpEntity<AudioVisuals> requestEntity = new HttpEntity<AudioVisuals>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(AudioVisuals entity) {
        final String url = BASE_URL+"audioVisuals/update/"+entity.getId().toString();
        HttpEntity<AudioVisuals> requestEntity = new HttpEntity<AudioVisuals>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(AudioVisuals entity) {
        final String url = BASE_URL+"audioVisuals/delete/"+entity.getId().toString();
        HttpEntity<AudioVisuals> requestEntity = new HttpEntity<AudioVisuals>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<AudioVisuals> getAll() {
        List<AudioVisuals> audioVisualsList = new ArrayList<>();
        final String url = BASE_URL+"audioVisuals/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<AudioVisuals[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, AudioVisuals[].class);
        AudioVisuals[] results = responseEntity.getBody();

        for (AudioVisuals audioVisuals : results) {
            audioVisualsList.add(audioVisuals);
        }
        return audioVisualsList;
    }
}
