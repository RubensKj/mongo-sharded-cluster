package com.rubenskj.mongo.sharded.service;

import com.rubenskj.mongo.sharded.dto.PlayerDTO;
import com.rubenskj.mongo.sharded.model.Player;
import com.rubenskj.mongo.sharded.repository.IPlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PlayerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    @Inject
    IPlayerRepository playerRepository;

    public Player add(PlayerDTO playerDTO) {
        LOGGER.debug("PlayerDTO: {}", playerDTO);

        Player player = this.createPlayerFromDTO(playerDTO);

        LOGGER.info("Saving player");

        return playerRepository.save(player);
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
