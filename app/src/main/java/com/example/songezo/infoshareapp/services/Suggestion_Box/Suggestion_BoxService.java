package com.example.songezo.infoshareapp.services.Suggestion_Box;

import com.example.songezo.infoshareapp.domain.Suggestion_Box;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public interface Suggestion_BoxService {
    Suggestion_Box getSuggestion_BoxByID(Long id);


    Suggestion_Box saveSuggestion_Box(Suggestion_Box entity);

    Set<Suggestion_Box> findAll();
}

