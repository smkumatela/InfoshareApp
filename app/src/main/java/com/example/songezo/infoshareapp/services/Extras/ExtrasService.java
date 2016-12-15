package com.example.songezo.infoshareapp.services.Extras;

import com.example.songezo.infoshareapp.domain.Extras;

import java.util.Set;

/**
 * Created by Mandisi on 12/14/2016.
 */

public interface ExtrasService {

    Extras getExtrasByID(Long id);


    Extras saveExtras(Extras entity);

    Set<Extras> findAll();
}

