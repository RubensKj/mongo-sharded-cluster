package com.rubenskj.mongo.sharded.controller;

import com.rubenskj.mongo.sharded.service.ShardMongo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/mongo-shard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TestShardMongo {

    @Inject
    ShardMongo shardMongo;

    @GET
    public String startTestShard() {
        this.shardMongo.startTestShard();

        return "Starting saving multiple users to test the shard..";
    }
}
