package com.sakilaAPI.service.impls;

import com.sakilaAPI.config.exceptions.BusinessException;
import com.sakilaAPI.database.entities.Actor;
import com.sakilaAPI.database.repos.RepositoryFactory;
import com.sakilaAPI.service.dtos.requests.ActorRequest;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import com.sakilaAPI.service.dtos.responses.ActorResponse;
import com.sakilaAPI.service.interfaces.ActorService;
import com.sakilaAPI.utils.mappers.ActorRequestMapper;
import com.sakilaAPI.utils.mappers.ActorResponseMapper;
import com.sakilaAPI.utils.mappers.BaseActorResponseMapper;
import jakarta.ws.rs.core.Response;

import java.time.Instant;
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
    public List<ActorResponse> getAllActors(int limit, int offset){
        return RepositoryFactory.getInstance().createActorRepository()
                .getAllEntities(limit, offset).stream()
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

    @Override
    public BaseActorResponse addActor(ActorRequest actor){
        Actor actorEntity = ActorRequestMapper.INSTANCE.toEntity(actor);
        actorEntity.setLastUpdate(Instant.now());
        return BaseActorResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createActorRepository().addEntity(
                        actorEntity
                )
        );
    }

    @Override
    public void deleteActor(int id){
        RepositoryFactory.getInstance().createActorRepository().deleteEntityById(id);
    }

    @Override
    public ActorResponse updateActor(ActorRequest actor, int id){
        Optional<Actor> actorEntity = RepositoryFactory.getInstance().createActorRepository()
                .getEntityById(id);
        if(actorEntity.isEmpty()){
            throw new BusinessException(Response.Status.NOT_FOUND.getReasonPhrase(),
                    Response.Status.NOT_FOUND.getStatusCode()
                    ,"Actor not found for ID: " + id );
        }
        ActorRequestMapper.INSTANCE.updateEntity(actor, actorEntity.get());
        return ActorResponseMapper.INSTANCE.toDto(
                RepositoryFactory.getInstance().createActorRepository().updateEntity(
                        actorEntity.get()
                )
        );
    }
}
