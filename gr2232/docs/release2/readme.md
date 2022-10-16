## Release 2

The major implementations of this release are as follows:
- Core logic
    - Core logic

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

Sequence diagram:
![Sequence diagram](./SequenceDiagram.png)

Package diagram:
![Package diagram](./packageDiagram.png)


Click [here](./workhabits.md) to read about workhabits and teamwork.