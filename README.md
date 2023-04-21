# Google Secret Manager Issue

Find `gcloud run services describe <service-name>` in `service.yaml`

## Deploy

To deploy the project, run `deploy.sh` which

1. Builds the Docker image
2. Pushes the docker image
3. Deploys the service

```bash
$ ./deploy.s <project-id>
```

Visit https://secret-manager-xxxxxxxx-ew.a.run.app/ or check service logs for the output:

```java
@Override
public void onApplicationEvent(@NonNull ApplicationContextEvent event) {
    LOGGER.info("###############################################################");
    LOGGER.info(String.format("# Secret: \"%s\"", this.someSecret));
    LOGGER.info("###############################################################");
}
```

## Service Account

The service account which is assigned to the service (see `service.yaml`) is `xxxxxxxxxxx-compute@developer.gserviceaccount.com`.

The `Secret Manager Secret Accessor` has been manually assigned to this service account.
