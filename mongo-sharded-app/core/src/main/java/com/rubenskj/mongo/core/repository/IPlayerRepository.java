package com.rubenskj.mongo.core.repository;

import com.rubenskj.mongo.core.model.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlayerRepository extends MongoRepository<Player, String> {
}
