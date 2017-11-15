# Suggester application (spring-boot, mongodb) 

The app's purpose is to store data of users and their corresponding actions into a document oriented database (MongoDB in this case). Future work will be integration with a streaming broker to listen to events, as well as forwarding the events further down the chain for processing

### Build
	mvn install

### Run
	mvn spring-boot:run
