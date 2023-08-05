# How to create a docker compose from a java service and connecto to database

## Create a network in docker

Creating a network in your docker environment will allow multiple docker service and database
to connect and talk to each other.

Use the following command to create the Docker Network for Eagle Eye:

```shell
docker network create eye-network
```

Example:

```shell
docker network create <network name>
```

To delete an existing network you can use the following command:

```shell
docker network rm <network name>
```

To add a connection to a new or existing service use the following command:

```shell
docker network connect <network name> <container name>
```

For example, you could connect Elastic Search with one of the Eye service
using the following command.

```shell
docker network connect eye-network eye_registry
docker network connect eye-network elasticsearch
```

## Create the Docker Configuration

Step #1. Create a `Dockerfile` that will contain the Java/.jar configurations.

```dockerfile
FROM eclipse-temurin:17-jdk-alpine
ADD target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
```

Step #2. Create the yml configuration file

```yaml
version: "3"
services:
  eye-registry-service:
    container_name: eye_registry
    image: eye_registry_image
    build: .
    ports:
      - 8081:8081
    environment:
      ES_HOST: elasticsearch
      SERVICE_PORT: 8081
    network_mode: "eye-network"

networks:
  default:
    external:
      name: eye-network
```

Step #3. Modify the property file to be dynamic with the environment variables passed by the
docker file.

```properties
spring.elasticsearch.uris=${ES_HOST:localhost}:9200
server.port=${SERVICE_PORT:8080}
```