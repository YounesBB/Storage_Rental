The program utilizes two diferent types percistence.


### Desktop Methaphor (Non-REST)
Upon selecting to use local storage (non REST), the user has the ability to click on the settings tab. Here, the user can specify a filename to save the current state of the program to a local JSON-file, or load the state of a previous session. This is using a desktop methaphor for saving/persistence, because you save or load in an explicit fashion. 


### Implicit persistence/app (REST)
Upon selecting remote storage (REST), the user does not have access to the settings tab. The user is therefor not able to explicitly save or load a session. The program fetches the state of the previous session from the REST-API, and does not save a local JSON file. The program adds units, tenants etc progressivly to the session if the REST-server accepts the request to do such actions. Using REST the persistence is done in an implicit fashion. 