package com.sakilaAPI.database.repos.impls;


import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.repos.interfaces.ActorRepository;

public class ActorRepositoryImpl extends RepositoryImpl<Actor> implements ActorRepository {

    public ActorRepositoryImpl() {
        super(Actor.class);
    }
}
