## Release 2

The major implementations of this release are as follows:
- Core logic
    - Improved core logic. Fixing of bugs and potential "dangerous" code from the first release
    - Added HandleUser.java
        - Used to store information about the user, if the user is a manager or employee. An employee can not create new storage units. 

- Modulazition 
    - Modulized into two major moduels; FXUI and Core. 

- Improved saving and loading of files
    - Using JSON format, and encoded using UTF-8

- Three-layer architecture 
    - Split core-logic, UI and JSON-saving into their respective packages
    - See PlantUML images(package diagram) for a visual understanding of the implementation


- More tests and improved test coverage
    - Added tests on GUI using TestFX. 
    - Added more JUnit tests

- Improved code quality 
    - Using Spotbugs to find and adress potential bugs and errors
    - Using Checkstyle to have a consistent styling


Click [here](./workhabits.md) to read about workhabits and teamwork, and reason for late submission. 

Click [here](../../config/jsonSchema/unit.schema.json) to see the JSON schema, that is a documentation for the JSON-data files. 

Sequence diagram:
![Sequence diagram](./SequenceDiagram.png)

Package diagram:
![Package diagram](./packageDiagram.png)
