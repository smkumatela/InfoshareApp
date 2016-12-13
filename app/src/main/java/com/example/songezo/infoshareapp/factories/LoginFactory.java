package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Login;

import java.util.Map;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class LoginFactory {

    Login login;

    private static LoginFactory loginFactory = null;

    public LoginFactory() {
    }

    public static LoginFactory getLogFactory(){
        if (loginFactory == null){
            loginFactory = new LoginFactory();
        }
        return loginFactory;
    }

    public static Login createLoginFactory(String username, String password, Long id){
        Login login1 = new Login.Builder()
                .username(username)
                .password(password)
                .id(321L)
                .build();

        return login1;
    }

    @Override
    public String toString() {
        return "LoginFactory{" +
                "loginFactory=" + login +
                '}';
    }
}
