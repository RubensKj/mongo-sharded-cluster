#!/bin/sh
echo "Stopping all mongos"
docker-compose stop
echo ' '
echo "---------------------"
sleep 2
echo "Starting all mongos"
docker-compose up --build --remove-orphans -d
echo ' '
echo "---------------------"
sleep 4
# docker-compose exec shard-1 mongo admin -u root -p password /root/replica-set-init.js
echo "Executing default configuration"
docker-compose exec shard-1 mongo admin --eval "rs.initiate({ _id: \"cluster-rs-1\", members: [{_id: 0, host: \"shard-1:27017\"}, {_id: 1, host: \"shard-2:27017\"}, {_id: 2, host: \"shard-3:27017\", arbiterOnly: true} ]});"
docker-compose exec shard-1 mongo admin --eval "var testdb = db.getSiblingDB('test');testdb.createCollection('test');"
docker-compose exec shard-1 mongo admin --eval "var testdb = db.getSiblingDB('test');testdb.createUser({ user: 'test', pwd: 'password', roles: [{ role: 'root', db: 'admin' }, { role: 'dbOwner', db: 'test' }]});testdb.getUsers();"