#!/bin/bash

# parameter name
IMAGE_NAME=ziimme/service
CONTAINER_NAME=ziimme-service
PORT=8080
NETWORK=bridge-net

# build image
docker build -t $IMAGE_NAME /server/Ziimme-api

# create container
docker create --name $CONTAINER_NAME -p $PORT:8080 --restart=always --network $NETWORK $IMAGE_NAME

# copy environment
docker cp /server/Ziimme-api/src/main/resources/application.properties $CONTAINER_NAME:/opt/app

# start container
docker start $CONTAINER_NAME