package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.requests.ActorRequest;
import com.sakilaAPI.service.dtos.responses.BaseActorResponse;
import com.sakilaAPI.service.dtos.responses.ActorResponse;

import java.util.List;

public interface ActorService {
    List<ActorResponse> getAllActors(int limit, int offset);

    ActorResponse getActor(int id);

    BaseActorResponse addActor(ActorRequest actor);

    void deleteActor(int id);

    ActorResponse updateActor(ActorRequest actor, int id);
}
