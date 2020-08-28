package com.speedment.jpastreamer.demo.model;

import com.speedment.jpastreamer.field.ComparableField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;

import java.util.List;

/**
 * The generated base for entity {@link Actor} representing entities of the
 * {@code actor}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public class Actor$ {
    
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getFilms()} method.
     */
    public static final ReferenceField<Actor, List<Film>> films = ReferenceField.create(
        Actor.class,
        "films",
        Actor::getFilms,
        false
    );
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getLastName()} method.
     */
    public static final StringField<Actor> lastName = StringField.create(
        Actor.class,
        "lastName",
        Actor::getLastName,
        false
    );
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getActorId()} method.
     */
    public static final ComparableField<Actor, Integer> actorId = ComparableField.create(
        Actor.class,
        "actorId",
        Actor::getActorId,
        false
    );
    /**
     * This Field corresponds to the {@link Actor} field that can be obtained
     * using the {@link Actor#getFirstName()} method.
     */
    public static final StringField<Actor> firstName = StringField.create(
        Actor.class,
        "firstName",
        Actor::getFirstName,
        false
    );
}