package com.speedment.jpastreamer.demo;

import com.speedment.jpastreamer.application.JPAStreamer;
import com.speedment.jpastreamer.demo.model.Film;
import com.speedment.jpastreamer.demo.model.Film$;
import com.speedment.jpastreamer.streamconfiguration.StreamConfiguration;

import javax.persistence.Tuple;
import java.util.function.Function;
import java.util.stream.Stream;

/** This example shows how to select films that are between 100 and 120 minutes long. */

public class SelectDemo {

    public static void main(String[] args) {

        JPAStreamer jpaStreamer = JPAStreamer.of("sakila");

        // This will be replaced by a better way in future versions

        jpaStreamer.stream(Film.class)
                .map(TitleLength::new)
                .forEach(System.out::println);


        jpaStreamer.close();




        // Called due to a bug in the MySQL JDBC driver
        // Thread mysql-cj-abandoned-connection-cleanup gets stuck
        // See https://github.com/speedment/jpa-streamer-demo/issues/1
        System.exit(0);
    }

    private static void printFilm(Film f) {
        System.out.printf("%4d %-25s %-5s %d%n", f.getFilmId(), f.getTitle(), f.getRating(), f.getLength());
    }

    public static final class TitleLength {

        private final String title;
        private final int length;

        public TitleLength(Film film) {
            this.title = film.getTitle();
            this.length= film.getLength();
        }

        public String title() {
            return title;
        }

        public int length() {
            return length;
        }

        @Override
        public String toString() {
            return "TitleLength{" +
                    "title='" + title + '\'' +
                    ", length=" + length +
                    '}';
        }
    }


}