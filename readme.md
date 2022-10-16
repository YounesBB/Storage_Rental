# Group gr2232 repository 
 
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

## Work habits, workflow and code quality

We have meetings where we together map out what the project needs, based on the requirements of the next release, when we need it done and an estimate of when we should have the next meeting. We then structure the work thats needed by writing them as issues on Github, which are then delegated between us. Who gets which issues gets decided by trying to give everyone a fair share of work, while also trying to diversify everyones type of work throughout the project. The issues are made with tags which communicate what kind of work that needs to be done. We choose between testing, core, infrastructure, UI, documentation or bug after whats most fitting. In addition to writing a description of what the issue is about. We also choose what release of the project the issue is made for and who gets assigned to it. The assignee then creates a branch out of the issue, and starts working out of said branch. If the assignee gets stuck he can easily get help as theres a high tolerance for anyone to ask for help from the group. The branch is then requested to merge to the masterbranch when the issue is complete, after firstly being commited with a message saying what has been done. The branch gets reviewed by another in the group before being confirmed and merged. We have kept an efficient and structured workflow by using this system.

We use a varierity of tools to ensure that our code quality is high. We do so through writing tests, using jacoco, spotbugs and checkstyle. Our approach to writing tests is by first writing our code to near completion, and then writing tests to the equivalent code. We write test code that checks that everything we want the project to do gets done correctly, while everything outside that is either not possible for the user to do, or gives errors. The tests are created by going through every method or graphical function and planing how it should and shouldnt work. We then write tests that checks that the code goes as previously planed. We then check with jacoco to show if tests are missing and then return to writing tests until we are satified. Furthermore we use checkstyle and spotbugs. We have the file eclipse-java-google-style.xml that controls the settings for checkstyle and exclude.xml for spotbugs. The settings for checkstyle follow the standard formating. Exclude.xml is a filter file which can pick up instances of bugs based on their bug pattern, which then get excluded from the typical bug treatment.
