package com.example.songezo.infoshareapp.repository;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public interface Repository <E, ID> {

    E findById(ID id);

    E save(E entity);

    E update(E entity);

    E delete(E entity);

    Set<E> findAll();

    int deleteAll();
}
