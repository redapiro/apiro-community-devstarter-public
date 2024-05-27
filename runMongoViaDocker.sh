#!/bin/bash

echo "RUNNING MONGO VIA DOCKER - DOCKER and MONGOSH MUST BE INSTALLED LOCALLY"
echo "WARNING - RUN WITH -it --rm >>> MONGO STATE WILL BE DELETED WHEN TERMINATED"

docker run --net=host --rm -i --name apiromongoinit mongo bash -c 'until mongosh --eval "print(\"waited for connection\")"; do sleep 1; done; mongosh --eval "rs.initiate()"' &
docker run -it --rm --name apiromongo -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME__=mongo -e MONGO_INITDB_ROOT_PASSWORD__=mongo  mongo:7 mongod --replSet rs0 --setParameter transactionLifetimeLimitSeconds=600
