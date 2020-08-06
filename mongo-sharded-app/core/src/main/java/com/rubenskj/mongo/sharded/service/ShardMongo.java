package com.rubenskj.mongo.sharded.service;

import com.rubenskj.mongo.sharded.dto.PlayerDTO;
import com.rubenskj.mongo.sharded.model.Player;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.UUID;

@ApplicationScoped
public class ShardMongo {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShardMongo.class);
    private static final int NUMBER_OF_TIMES = 1;

    @Inject
    PlayerService playerService;

    public void startTestShard() {

        for (int i = 0; i < NUMBER_OF_TIMES; i++) {

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
