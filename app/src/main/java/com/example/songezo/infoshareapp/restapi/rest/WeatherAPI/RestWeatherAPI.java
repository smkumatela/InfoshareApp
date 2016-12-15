package com.example.songezo.infoshareapp.restapi.rest.WeatherAPI;

import com.example.songezo.infoshareapp.domain.Weather;
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

public class RestWeatherAPI implements RestAPI<Weather,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Weather get(Long id) {
        final String url = BASE_URL+"weather/"+id.toString();
        HttpEntity<Weather> requestEntity = new HttpEntity<Weather>(requestHeaders);
        ResponseEntity<Weather> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Weather.class);
        Weather weather = responseEntity.getBody();
        return weather;
    }

    @Override
    public String post(Weather entity) {
        final String url = BASE_URL+"weather/create";
        HttpEntity<Weather> requestEntity = new HttpEntity<Weather>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Weather entity) {
        final String url = BASE_URL+"weather/update/"+entity.getId().toString();
        HttpEntity<Weather> requestEntity = new HttpEntity<Weather>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Weather entity) {
        final String url = BASE_URL+"weather/delete/"+entity.getId().toString();
        HttpEntity<Weather> requestEntity = new HttpEntity<Weather>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Weather> getAll() {
        List<Weather> weatherList = new ArrayList<>();
        final String url = BASE_URL+"weather/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Weather[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Weather[].class);
        Weather[] results = responseEntity.getBody();

        for (Weather weather : results) {
            weatherList.add(weather);
        }
        return weatherList;
    }
}