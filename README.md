# Google Secret Manager Issue

## Deploy

To deploy the project, run `deploy.sh` which builds, pushes and deploys the Docker-image

```bash
$ ./deploy.sh <project-id>
```

Visit https://secret-manager-xxxxxxxx-ew.a.run.app/ or check service logs for output.

## Run Locally

In order to run/test/debug locally, run the application by activating profile `local-gcp` and setting

```none
GOOGLE_APPLICATION_CREDENTIALS=/path/to/credentials.json
PROJECT_ID=<project-id>
```

**See also**

 - `src/main/resources/application-local-gcp.yaml`
