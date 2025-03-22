#!/bin/bash

# parameter name
IMAGE_NAME=ziimme/service
CONTAINER_NAME=ziimme-service
PORT=8080
NETWORK=bridge-net
PATH_CONFIG="/home/ubuntu/Ziimme-api/src/main/resources/application.properties"

# remove container
docker rm -f $CONTAINER_NAME

# remove images
docker rmi $IMAGE_NAME

# build image
docker build -t $IMAGE_NAME .

# create container
docker create --name $CONTAINER_NAME -p $PORT:8080 --restart=always --network $NETWORK $IMAGE_NAME

# copy environment
docker cp $PATH_CONFIG $CONTAINER_NAME:/opt/app

# start container
docker start $CONTAINER_NAME
