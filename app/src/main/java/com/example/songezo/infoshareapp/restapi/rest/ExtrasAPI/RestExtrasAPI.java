package com.example.songezo.infoshareapp.restapi.rest.ExtrasAPI;

import com.example.songezo.infoshareapp.domain.Extras;
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

public class RestExtrasAPI implements RestAPI<Extras,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public Extras get(Long id) {
        final String url = BASE_URL+"extras/"+id.toString();
        HttpEntity<Extras> requestEntity = new HttpEntity<Extras>(requestHeaders);
        ResponseEntity<Extras> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Extras.class);
        Extras extras = responseEntity.getBody();
        return extras;
    }

    @Override
    public String post(Extras entity) {
        final String url = BASE_URL+"extras/create";
        HttpEntity<Extras> requestEntity = new HttpEntity<Extras>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(Extras entity) {
        final String url = BASE_URL+"extras/update/"+entity.getId().toString();
        HttpEntity<Extras> requestEntity = new HttpEntity<Extras>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(Extras entity) {
        final String url = BASE_URL+"extras/delete/"+entity.getId().toString();
        HttpEntity<Extras> requestEntity = new HttpEntity<Extras>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<Extras> getAll() {
        List<Extras> extrasList = new ArrayList<>();
        final String url = BASE_URL+"extras/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<Extras[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Extras[].class);
        Extras[] results = responseEntity.getBody();

        for (Extras extras : results) {
            extrasList.add(extras);
        }
        return extrasList;
    }
}
