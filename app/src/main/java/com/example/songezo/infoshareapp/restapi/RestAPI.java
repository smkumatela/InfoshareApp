package com.example.songezo.infoshareapp.restapi;

import java.util.List;

/**
 * Created by asiphe.dyani on 2016/12/14.
 */

public interface RestAPI <S, ID> {

    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();

}
