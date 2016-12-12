package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Extras;
import com.example.songezo.infoshareapp.domain.MainMenu;
import com.example.songezo.infoshareapp.domain.MessagingContacts;
import com.example.songezo.infoshareapp.domain.MyPatient;
import com.example.songezo.infoshareapp.domain.SeeStories;
import com.example.songezo.infoshareapp.domain.ShareStories;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class MainMenuFactory {


    MainMenu mainMenu;

    private static MainMenuFactory mainMenuFactory = null;

    public MainMenuFactory() {
    }

    public static MainMenuFactory getMainMenuFactory(){
        if (mainMenuFactory == null){
            mainMenuFactory = new MainMenuFactory();
        }
        return mainMenuFactory;
    }

    public static MainMenu createMainMenuFactory(MyPatient myPatient, ShareStories shareStories, MessagingContacts messagingContacts, SeeStories seeStories, Extras extras, Long id){
        MainMenu mainMenu1 = new MainMenu.Builder()
                .myPatient(myPatient)
                .stories(shareStories)
                .messagingContacts(messagingContacts)
                .seeStories(seeStories)
                .extras(extras)
                .id(id)
                .build();
        return mainMenu1;
    }

    @Override
    public String toString() {
        return "MainMenuFactory{" +
                "mainMenu=" + mainMenu +
                '}';
    }

}
