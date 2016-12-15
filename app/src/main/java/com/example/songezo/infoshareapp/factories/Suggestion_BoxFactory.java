package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Suggestion_Box;

/**
 * Created by Mandisi on 12/13/2016.
 */

public class Suggestion_BoxFactory {
    Suggestion_Box suggestion_Box;

    private static Suggestion_BoxFactory suggestion_BoxFactory = null;

    public Suggestion_BoxFactory() {
    }

    public static Suggestion_BoxFactory getLogFactory(){
        if (suggestion_BoxFactory == null){
            suggestion_BoxFactory = new Suggestion_BoxFactory();
        }
        return suggestion_BoxFactory;
    }

    public static Suggestion_Box createSuggestion_BoxFactory(Long id){
        Suggestion_Box suggestion_Box1 = new Suggestion_Box.Builder()
                .id(id)
                .build();

        return suggestion_Box1;
    }

    @Override
    public String toString() {
        return "suggestion_BoxFactory{" +
                "suggestion_Box=" + suggestion_Box +
                '}';
    }
}

