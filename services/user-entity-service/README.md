# Build and run
Use “mvn package” to make the JAR. Navigate to target folder in your project and run the JAR. 
Two arguments are needed in order to run the JAR. First is “server” which instructs Dropwizard to run as server. 
Second is path to *.yml configuration file.

java -jar <app>.jar server ../config.yml
If everything is fine you should see something like code bellow which will mean server is ready.

    DELETE  /user/delete/{id} (rest.resources.UserResource)
    GET     /user/get (rest.resources.UserResource)
    GET     /user/get/{id} (rest.resources.UserResource)
    POST    /user/save (rest.resources.UserResource)
    PUT     /user/update (rest.resources.UserResource)

# REST Requests
Use your REST/HTTP API Client (like DHC on Google Chrome) to import restful-requests.json file for examples.
