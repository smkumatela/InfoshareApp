package com.example.songezo.infoshareapp.services.mainmenu;

import com.example.songezo.infoshareapp.domain.MainMenu;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface MainMenuService {

    MainMenu getMainMenuByID(Long id);


    MainMenu saveMainMenu(MainMenu entity);

    Set<MainMenu> findAll();
}
