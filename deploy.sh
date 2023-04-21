#!/bin/bash

if [ -z "$1" ]; then
  echo "Missing PROJECT_ID; Run \"deploy.sh <project-id>\""
  exit 1;
fi

PROJECT_ID=$1
REGISTRY=gcr.io
IMAGE_TAG=secret-manager:0.0.0

docker build -t $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG . || exit

docker push $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG || exit

gcloud run deploy \
  secret-manager \
  --image $REGISTRY/"$PROJECT_ID"/$IMAGE_TAG \
  --project "$PROJECT_ID" \
  --region europe-west1 \
  || exit
