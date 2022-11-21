# FXUI module

This is the user interface (frontend) module for gr2232.

## Information

The fxui module consists of all classes, logic and .fxml files that creates the UI and handles user interaction. The UI allows an employee or admin manage units in a unit storage house. The detalies of what the user can do is already explained [here](../../README.md#about) and at [userstories](../../userStories.md). 

The UI builds by using JavaFX. The JavaFX code is in [src/main/java/gr2232/ui](src/main/java/gr2232/ui) and the FXML files can be found in [src/main/resources/gr2232/ui](src/main/resources/gr2232/ui). The application uses JavaFX version 16. 


## Maven build

In addition to the plugins used [project-wide](../README.md#structure_and_maven_build), we use the following plugins in the FXUI module to run our client application/user interface:

- [JavaFX](https://github.com/openjdk/jfx) to create and show a client UI
- [TestFX](https://github.com/TestFX/TestFX) to test the JavaFX application