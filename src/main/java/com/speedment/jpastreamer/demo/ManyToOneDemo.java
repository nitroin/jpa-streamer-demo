package com.speedment.jpastreamer.demo;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.demo.model.Film;
import com.speedment.jpastreamer.demo.model.Film$;
import com.speedment.jpastreamer.demo.model.Language;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A Many-to-One relationship is defined as a relationship between two tables where many multiple rows
 * from a first table can match the same single row in a second table.
 * For example, a single language may be used in many films.
 *
 * This example maps every film with rating PG-13 to its spoken language.
 */
public class ManyToOneDemo {

    public static void main(String[] args) {

        JPAStreamer jpaStreamer = JPAStreamer.createJPAStreamerBuilder("sakila")
                .build();

        Map<Film, Language> languageMap = jpaStreamer.stream(Film.class)
                .filter(Film$.rating.equal("PG-13"))
                .collect(
                        Collectors.toMap(Function.identity(),
                                Film::getLanguage
                        )
                );

        languageMap
                .forEach(
                        (k, v) -> System.out.format("%s: %s\n", k.getTitle(), v.getName()));

        jpaStreamer.close();
    }
}
