package com.rubenskj.mongo.core.controller;

import com.rubenskj.mongo.core.dto.PlayerDTO;
import com.rubenskj.mongo.core.service.PlayerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public PlayerDTO add(@RequestBody PlayerDTO playerDTO) {
        return PlayerDTO.of(this.playerService.add(playerDTO));
    }
}
