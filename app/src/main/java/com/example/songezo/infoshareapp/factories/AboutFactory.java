package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.About;

import java.util.Map;

/**
 * Created by VERNON on 2016/12/10.
 */
public class AboutFactory {

    About about;

    private static AboutFactory aboutFactory = null;

    public AboutFactory() {
    }

    public static AboutFactory getAboutFactory(){
        if (aboutFactory == null){
            aboutFactory = new AboutFactory();
        }
        return aboutFactory;
    }

    public static About createAbout(String aboutInfoshare, Long id){
        About about1 = new About.Builder()
                .id(6345L)
                .aboutInfoshare("Sharing information")
                .build();
        return about1;
    }

    @Override
    public String toString() {
        return "AboutFactory{" +
                "About = " + about +
                '}';
    }
}
