#!/bin/bash

PROJECT_ID=$1
REGISTRY=gcr.io
IMAGE_TAG=secret-manager:0.0.0

docker build -t $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG . || exit

docker push $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG || exit

gcloud run deploy \
  server \
  --image $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG \
  --project "$PROJECT_ID" \
  --region europe-west1 \
  || exit
