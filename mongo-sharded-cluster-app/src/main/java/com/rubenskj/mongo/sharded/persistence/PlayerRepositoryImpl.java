package com.rubenskj.mongo.sharded.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.result.InsertOneResult;
import com.rubenskj.mongo.sharded.model.Player;
import com.rubenskj.mongo.sharded.repository.IPlayerRepository;
import io.quarkus.runtime.Startup;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Objects;

import static com.rubenskj.mongo.sharded.configuration.AppConfig.DATABASE_NAME;

@Startup
@ApplicationScoped
public class PlayerRepositoryImpl implements IPlayerRepository {

    @Inject
    MongoClient mongoClient;

    private MongoCollection getCollection() {
        return this.mongoClient.getDatabase(DATABASE_NAME).getCollection(Player.class.getSimpleName().toLowerCase());
    }

    @Override
    public Player save(Player player) {
        Document document = new Document();

        this.setPlayerAttributes(player, document);

        InsertOneResult insertOneResult = getCollection().insertOne(document);

        return new Player(Objects.requireNonNull(insertOneResult.getInsertedId()).asObjectId().getValue().toString(), player.getName(), player.getAge(), player.getPosition(), player.getFavoriteCharacters(), player.getCreatedAt());
    }

    private void setPlayerAttributes(Player player, Document document) {
        document.append("name", player.getName());
        document.append("age", player.getAge());
        document.append("position", player.getPosition());
        document.append("favoriteCharacters", player.getFavoriteCharacters());
    }
}
