package com.rubenskj.mongo.core.controller;

import com.rubenskj.mongo.core.service.ShardMongo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo-shard")
public class TestShardMongo {

    private final ShardMongo shardMongo;

    public TestShardMongo(ShardMongo shardMongo) {
        this.shardMongo = shardMongo;
    }

    @GetMapping("/{numberTimes}")
    public String startTestShard(@PathVariable("numberTimes") Long numberOfTimes) {
        this.shardMongo.startTestShard(numberOfTimes);

        return "Starting saving multiple users to test the shard..";
    }
}
