package com.rubenskj.mongo.core.controller;

import com.rubenskj.mongo.core.dto.PlayerDTO;
import com.rubenskj.mongo.core.service.PlayerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public PlayerDTO add(PlayerDTO playerDTO) {
        return PlayerDTO.of(this.playerService.add(playerDTO));
    }
}
