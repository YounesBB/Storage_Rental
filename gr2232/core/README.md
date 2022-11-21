# Core module

This is the core module for gr2232. It consists of the logic layer, serializer/deserializer and persistence to and from file. 

## Information

The core module containes all the classes that deal with what we can call the backend of the application. The module is seperate from the UI (fxml) and the type of persistence the user chooses.

The module can be seperated in two parts: core (logic) and json(persistence, serializer/deserializer).

### Core:
Core contains the logic of the application. It manages units and units in a unitlist. It also takes care of validating values entered into a unit and as such also validates which units can go into a Unitlist. Core can be find here [gr2232/core/src/main/java/gr2232/core](src/main/java/gr2232/core/)

### Json: 

Json takes care of persitence to and from .json files. It also handels serializing and deserializing. This means the reading and writing of Unit or UnitList to a .json object. This can be done both remotely and locally. For example the server might pass a UnitList as a json object. This will then be deserialized into a UnitList object. 


## Maven build

In addition to the dependencies used [project-wide](../README.md#structure_and_maven_build), the application also use the following plugins in the Core module:

- [Jackson](https://github.com/FasterXML/jackson) to handle serializing and deserializing
- [GSON](https://github.com/google/gson) persitence to and from file. 