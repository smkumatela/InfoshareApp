package com.example.songezo.infoshareapp.restapi.rest.messagingContactsAPI;

import com.example.songezo.infoshareapp.domain.MessagingContacts;
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

public class RestMessagingContactsAPI implements RestAPI<MessagingContacts,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public MessagingContacts get(Long id) {
        final String url = BASE_URL+"messagingcontacts/"+id.toString();
        HttpEntity<MessagingContacts> requestEntity = new HttpEntity<MessagingContacts>(requestHeaders);
        ResponseEntity<MessagingContacts> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MessagingContacts.class);
        MessagingContacts messagingContacts = responseEntity.getBody();
        return messagingContacts;
    }

    @Override
    public String post(MessagingContacts entity) {
        final String url = BASE_URL+"messagingcontacts/create";
        HttpEntity<MessagingContacts> requestEntity = new HttpEntity<MessagingContacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(MessagingContacts entity) {
        final String url = BASE_URL+"messagingcontacts/update/"+entity.getId().toString();
        HttpEntity<MessagingContacts> requestEntity = new HttpEntity<MessagingContacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(MessagingContacts entity) {
        final String url = BASE_URL+"messagingcontacts/delete/"+entity.getId().toString();
        HttpEntity<MessagingContacts> requestEntity = new HttpEntity<MessagingContacts>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<MessagingContacts> getAll() {
        List<MessagingContacts> messagingContactsList = new ArrayList<>();
        final String url = BASE_URL+"messagingcontactss/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<MessagingContacts[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MessagingContacts[].class);
        MessagingContacts[] results = responseEntity.getBody();

        for (MessagingContacts messagingContacts : results) {
            messagingContactsList.add(messagingContacts);
        }
        return messagingContactsList;
    }
}
