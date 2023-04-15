package com.sakilaAPI.service.interfaces;

import com.sakilaAPI.service.dtos.responses.ActorResponse;

import java.util.List;

public interface ActorService {
    List<ActorResponse> getAllActors();

    ActorResponse getActor(int id);
}
