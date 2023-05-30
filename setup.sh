#!/bin/bash
# -------------------------------- Angular ----------------------------------
IMAGE_NAME="wiimme/service"
TAG="1.0"
CONTAINER_NAME="wiimme-service"
NETWORK="bridge-net"
PUB_PORT=8081
# ---------------------------------------------------------------------------
sudo docker stop $CONTAINER_NAME
sudo docker rm   $CONTAINER_NAME
sudo docker rmi  $IMAGE_NAME:$TAG
# ---------------------------------------------------------------------------
sudo docker build -t $IMAGE_NAME:$TAG /server/Ziimme-api
sudo docker run --name $CONTAINER_NAME \
                --network $NETWORK \
                -p $PUB_PORT:8081 \
                --restart=always \
                -d $IMAGE_NAME:$TAG