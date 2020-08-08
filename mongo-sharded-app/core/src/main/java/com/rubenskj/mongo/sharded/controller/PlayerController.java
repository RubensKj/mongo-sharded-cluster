package com.rubenskj.mongo.sharded.controller;

import com.rubenskj.mongo.sharded.dto.PlayerDTO;
import com.rubenskj.mongo.sharded.service.PlayerService;
import com.rubenskj.mongo.sharded.service.Test;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerController {

    @Inject
    PlayerService playerService;

    @Inject
    Test test;

    @POST
    public PlayerDTO add(PlayerDTO playerDTO) {
        return PlayerDTO.of(this.playerService.add(playerDTO));
    }

    @GET
    public void ex() throws InterruptedException {
        this.test.serve();
    }
}
