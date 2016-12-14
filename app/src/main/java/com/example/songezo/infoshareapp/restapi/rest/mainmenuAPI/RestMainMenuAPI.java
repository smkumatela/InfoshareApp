package com.example.songezo.infoshareapp.restapi.rest.mainmenuAPI;

import com.example.songezo.infoshareapp.domain.MainMenu;
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

public class RestMainMenuAPI implements RestAPI<MainMenu,Long> {

    final String BASE_URL="http//localhost:8080/api/";

    final HttpHeaders requestHeaders = RestMethods.getHeaders();
    final RestTemplate restTemplate = RestMethods.getRestTemplate();

    @Override
    public MainMenu get(Long id) {
        final String url = BASE_URL+"mainmenu/"+id.toString();
        HttpEntity<MainMenu> requestEntity = new HttpEntity<MainMenu>(requestHeaders);
        ResponseEntity<MainMenu> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MainMenu.class);
        MainMenu mainMenu = responseEntity.getBody();
        return mainMenu;
    }

    @Override
    public String post(MainMenu entity) {
        final String url = BASE_URL+"mainmenu/create";
        HttpEntity<MainMenu> requestEntity = new HttpEntity<MainMenu>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String put(MainMenu entity) {
        final String url = BASE_URL+"mainmenu/update/"+entity.getId().toString();
        HttpEntity<MainMenu> requestEntity = new HttpEntity<MainMenu>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        String result = responseEntity.getBody();
        return result;
    }

    @Override
    public String delete(MainMenu entity) {
        final String url = BASE_URL+"mainmenu/delete/"+entity.getId().toString();
        HttpEntity<MainMenu> requestEntity = new HttpEntity<MainMenu>(entity, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public List<MainMenu> getAll() {
        List<MainMenu> mainMenuList = new ArrayList<>();
        final String url = BASE_URL+"mainmenus/";
        HttpEntity<?> requestEntity = new HttpEntity<Object>(requestHeaders);
        ResponseEntity<MainMenu[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, MainMenu[].class);
        MainMenu[] results = responseEntity.getBody();

        for (MainMenu mainMenu : results) {
            mainMenuList.add(mainMenu);
        }
        return mainMenuList;
    }
}
