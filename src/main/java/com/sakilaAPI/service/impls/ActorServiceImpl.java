package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.interfaces.ActorService;
import com.sakilaAPI.utils.mappers.ActorResponseMapper;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ActorServiceImpl implements ActorService {
    private static ActorServiceImpl actorService;

    private ActorServiceImpl(){}

    public static ActorService getActorService(){
        if(actorService == null)
            actorService = new ActorServiceImpl();
        return actorService;
    }

    @Override
    public List<ActorResponse> getAllActors(){
        return RepositoryFactory.getInstance().createActorRepository()
                .getAllEntities().stream()
                .map(ActorResponseMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    @Override
    public ActorResponse getActor(int id){
        Optional<Actor> actor = RepositoryFactory.getInstance().createActorRepository()
                .getEntityById(id);
        if(actor.isPresent()){
            return ActorResponseMapper.INSTANCE.toDto(actor.get());
        }else {
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Actor not found for ID: " + id );
        }
    }
}
