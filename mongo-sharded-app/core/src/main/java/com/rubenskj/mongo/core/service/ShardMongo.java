package com.rubenskj.mongo.core.service;

import com.rubenskj.mongo.core.dto.PlayerDTO;
import com.rubenskj.mongo.core.model.Player;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@Service
public class ShardMongo {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShardMongo.class);

    private final PlayerService playerService;

    public ShardMongo(PlayerService playerService) {
        this.playerService = playerService;
    }

    public void startTestShard(Long numberOfTimes) {

        if (numberOfTimes == null) {
            LOGGER.info("Number of times is null, so setting to 10000.");
            numberOfTimes = 10000L;
        }

        for (int i = 0; i < numberOfTimes; i++) {

            PlayerDTO playerDTO = this.createPlayerDTO();

            Player player = this.playerService.add(playerDTO);

            if (player != null && StringUtils.isEmpty(player.getId())) {
                LOGGER.error("Id is empty, cannot save user.");
                System.exit(1);
            }
        }
    }

    private PlayerDTO createPlayerDTO() {
        return new PlayerDTO(
                "player_name-".concat(UUID.randomUUID().toString()),
                new Random().ints(0, 88).iterator().nextInt(),
                "player_position-".concat(UUID.randomUUID().toString()),
                new ArrayList<>(Collections.singleton(UUID.randomUUID().toString()))
        );
    }
}
