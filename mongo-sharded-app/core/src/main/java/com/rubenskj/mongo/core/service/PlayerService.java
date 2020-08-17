package com.rubenskj.mongo.core.service;

import com.rubenskj.mongo.core.dto.PlayerDTO;
import com.rubenskj.mongo.core.model.Player;
import com.rubenskj.mongo.core.repository.IPlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    private final IPlayerRepository playerRepository;

    public PlayerService(IPlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player add(PlayerDTO playerDTO) {
        LOGGER.debug("PlayerDTO: {}", playerDTO);

        Player player = this.createPlayerFromDTO(playerDTO);

        LOGGER.info("Saving player");

        return this.playerRepository.save(player);
    }

    private Player createPlayerFromDTO(PlayerDTO playerDTO) {
        return new Player(
                playerDTO.getName(),
                playerDTO.getAge(),
                playerDTO.getPosition(),
                playerDTO.getFavoriteCharacters()
        );
    }
}
