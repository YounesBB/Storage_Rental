# Group gr2232 repository 
[![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.stud.ntnu.no/#https://gitlab.stud.idi.ntnu.no/it1901/groups-2022/gr2232) 

## Getting started

Clone or download the repository. Navigate into gr2232. Execute the following command in your terminal:

```console
foo@bar:~/gr2232/gr2232
mvn install
```

The project is now ready to use. 
To run the project on your computer, navigate to the FXUI directory, and execute the following command:

```console
foo@bar:~/gr2232/gr2232/fxui
mvn javafx:run
```

This project uses Spotbugs to find possible errors,bugs and vulnerabilities. Keep in mind Spotbugs will issue a Build Fail if any spotbugs are found. Project also uses Checkstyle to keep the same styling and indendation on the files. To run these plugins, execute the following command:

```console
foo@bar:~/gr2232/gr2232
mvn verify
```

The project contains JUnit tests, aswell as GUI tests using TestFX.
To run tests for the project, do:

```console
foo@bar:~/gr2232/gr2232
mvn test
```

To see the test-coverage for the project, execute the following command:
```console
foo@bar:~/gr2232/gr2232
mvn jacoco:report
```
Then navigate to the following directories:
```console
foo@bar:~/gr2232/gr2232/core/target/site/jacoco

foo@bar:~/gr2232/gr2232/fxui/target/site/jacoco
```
And open the corresponding index.html files. Note that you have to run maven test before looking at the test-coverage.

 

Click [here](gr2232/docs/release2/readme.md) to see documentation for the second release. 



### **A system for managing storage units!**

Our program is meant to work as a system for managing units in a units warehouse.

This means that the bussiness owner/manager can in the program:

1. Register the amount of units 
2. View leased out and free units. 
3. Lease out units or remove tenanats from units. 

The usercharacters used in this project can be read [here](brukerhistorier.md)

Most of the logic/code of the program is in [gr2232/src/main/java/gr2232](gr2232/src/main/java/gr2232) 

Under is a low-fidelity wireframe of the program. It also shows the flow of the program (from top to bottom). 

![Semantic description of image](gr2232/docs/release1/low-fidelity-wireframePNG.png "low-fidelity-wireframePNG")
