# full-indexer-elasticsearch [![Build Status](https://travis-ci.org/mozammal/full-indexer-elasticsearch.svg?branch=master)](https://travis-ci.org/mozammal/full-indexer-elasticsearch)
## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)
- [Docker](https://www.docker.com)
- [ElasticSearch 6](https://www.elastic.co)


## Running the application locally

clone the repo with the command given below: 
```shell
git clone https://github.com/mozammal/full-indexer-elasticsearch.git
```

One way to run this application is to use docker-compose from the command line
(tested on ubuntu 18.04.1):

```shell
cd full-indexer-elasticsearch
mvn clean package
sudo sysctl -w vm.max_map_count=262144
sudo docker-compose up -d
```

One way to stop this application is to use docker-compose from the command line
(tested on ubuntu 18.04.1):

```shell
sudo docker-compose stop
```



The REST APIs documentation can be accessed at 
- [APIs doc link](http://localhost:8080/swagger-ui.html) 