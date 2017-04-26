# network-client-service

### How to use

Build the project by running `gradle build` in the project root folder:

````bash
$ gradle build
````

The port values can be configured using environment variables:

````bash
$ export REGISTRY_SERVICE_PORT=9001

$ export WEB_SERVICE_PORT=9101

$ export CALCULATOR_SERVICE_PORT=9201
````

The default port values for the Registry, Web, and Calculator services are 9000, 9100, and 9200 respectively.

 Now start the registry service:

 ````bash
 $ java -jar build/libs/registry-1.0-SNAPSHOT.jar
 ````

 You should now be able to see the Eureka view at [localhost:9000](http://localhost:9000) or at whichever port you set `REGISTRY_SERVICE_PORT` to.

 Now you can start the other services (in separate windows if necessary):

 ````bash
 $ java -jar build/libs/web-service-1.0-SNAPSHOT.jar

 $ java -jar build/libs/calculator-service-1.0-SNAPSHOT.jar
 ````

 Ensure that the environment variables are consistent throughout.

 You should now see the services registered on Eureka and the ports that they are running on.

 Now you can make a request to the web service:

 http://localhost:9100/
