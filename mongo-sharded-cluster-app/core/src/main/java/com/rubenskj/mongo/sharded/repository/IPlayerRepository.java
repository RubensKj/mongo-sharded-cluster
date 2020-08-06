package com.rubenskj.mongo.sharded.repository;

import com.rubenskj.mongo.sharded.model.Player;

public interface IPlayerRepository {

    Player save(Player player);
}
