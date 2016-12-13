package com.example.songezo.infoshareapp.services.login;

import com.example.songezo.infoshareapp.domain.Login;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface LoginService {

    Login getLoginByID(Long id);


    Login saveLogin(Login entity);

    Set<Login> findAll();
}
