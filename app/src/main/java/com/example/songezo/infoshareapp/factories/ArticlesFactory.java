package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Articles;

import java.util.Date;
import java.util.Map;

/**
 * Created by VERNON on 2016/12/10.
 */
public class ArticlesFactory {

    Articles articles;

    private static ArticlesFactory articleFactory = null;

    public ArticlesFactory() {
    }

    public static ArticlesFactory getArticleFactory(){
        if (articleFactory == null){
            articleFactory = new ArticlesFactory();
        }
        return articleFactory;
    }

    public static Articles createArticle(String category, String topic, Date date, Long id){
        Articles articles1 = new Articles.Builder()
                .category("category data")
                .topic("sharing information")
                .id(5345L)
                .date(date)
                .build();
        return articles1;
    }

    @Override
    public String toString() {
        return "ArticlesFactory{" +
                "Articles = " + articles +
                '}';
    }
}
