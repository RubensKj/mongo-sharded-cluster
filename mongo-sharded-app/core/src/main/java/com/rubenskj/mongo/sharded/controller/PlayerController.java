package com.rubenskj.mongo.sharded.controller;

import com.rubenskj.mongo.sharded.dto.PlayerDTO;
import com.rubenskj.mongo.sharded.service.PlayerService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PlayerController {

    @Inject
    PlayerService playerService;

    @POST
    public PlayerDTO add(PlayerDTO playerDTO) {
        return PlayerDTO.of(this.playerService.add(playerDTO));
    }
}
