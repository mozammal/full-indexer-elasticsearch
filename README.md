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

One way to run this application is to use docker-compose from the command line:

```shell
cd full-indexer-elasticsearch
mvn clean package
sudo docker-compose up -d
```

One way to stop this application is to use docker-compose from the command line
(tested on ubuntu 18.04.1):

```shell
sudo docker-compose stop
```



The REST APIs documentation can be accessed at 
- [APIs doc link](http://localhost:8080/swagger-ui.html) 

# Sample JSON Payload for the POSt Request:

```shell
{
   "articleContent":{
      "source":{
         "id":null,
         "name":"Autoblog"
      },
      "author":"James Riswick",
      "title":"Ineos Grenadier Quartermaster First Drive Review: Dripping in character, damned by chickens",
      "description":"Filed under:\n First Drives,Truck,SUV,Luxury,Off-Road Vehicles,Ineos\n Continue reading Ineos Grenadier Quartermaster First Drive Review: Dripping in character, damned by chickens\nIneos Grenadier Quartermaster First Drive Review: Dripping in character, damned b…",
      "url":"https://www.autoblog.com/2024/06/17/ineos-grenadier-quartermaster-first-drive-review/",
      "urlToImage":"https://s.aolcdn.com/images/dims3/GLOB/legacy_thumbnail/1062x597/format/jpg/quality/100/https://s.aolcdn.com/os/ab/_cms/2024/06/14123730/Ineos-Grenadier-Quartermaster-action-front-three-quarter-in-the-shrubs.jpg",
      "publishedAt":"2024-06-17T07:00:00Z",
      "content":"JOSHUA TREE, Calif. Subjectively, the 2025 Ineos Grenadier Quartermaster is a deeply lovable truck. It is dripping in character, from the bank of cockpit-style switches on the dash and ceiling consol… [+10049 chars]"
   }
}
```