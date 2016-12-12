package com.example.songezo.infoshareapp.domain;


/**
 * Created by asiphe.dyani on 2016/12/09.
 */

public class Login {
    private Long id;
    private String username;
    private String password;


    public Login(Builder builderObjt){
        id = builderObjt.id;
        username = builderObjt.username;
        password = builderObjt.password;
    }

    public Login(String username, String password, Long id){
        this.id = id;
        this.username = username;
        this.password = password;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }


    public static class Builder{
        private Long id;
        private String username;
        private String password;

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder id(Long id){
            this.id = id;
            return this;
        }

        public Builder copyObj(Login loginObj){
            this.id = loginObj.getId();
            this.username = loginObj.getUsername();
            this.password = loginObj.getPassword();
            return this;
        }

        public Login build(){
            return new Login(this);
        }
    }


}
