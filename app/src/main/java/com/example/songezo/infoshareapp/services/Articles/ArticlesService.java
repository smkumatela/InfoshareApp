package com.example.songezo.infoshareapp.services.Articles;

import com.example.songezo.infoshareapp.domain.Articles;

import java.util.Set;

/**
 * Created by VERNON on 2016/12/13.
 */
public interface ArticlesService {

    Articles getArticlesByID(Long id);


    Articles saveArticles(Articles entity);

    Set<Articles> findAll();
}
