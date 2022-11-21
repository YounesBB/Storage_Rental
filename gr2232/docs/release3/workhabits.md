## Work habits, workflow and code quality

### Work habits 

The group started this iteration with a meeting to map out what needed to be done to fit the requirements, as well as our own motivation and goals. Started mapping out new possible features to add, and figuring out a way to set up a REST server. We set up initial issues following this meeting, and started working.

We have also had "daily" meetings when we met, compliant of the ones used in SCRUM. Everybody shared what they have done, what they plan on doing next, and if anybody needed help to solve their issues. We did some pair-programming, allthough usually only if some of us were struggling to complete their issue. This was done either digitally using screensharing or Live Share, or in person. 

### Workflow using Git

Efficient use of Git is crucial in developing in a team. The group has done all work through creating issues and branching from their respective issue. Each issue got a descreption, attached tags, and assigned to a member. We started using conventional commits in this issue, further clarifying what had been done in a commit-message. Conventional commits were written using VS Code extensions. Read more about conventional commits [here](https://www.conventionalcommits.org/en/v1.0.0/)

After an issue was resolved, a merge request was made. The merge-request had to be approved and looked over by another groupmember to assure code-quality and that the build would be stable. 

### Code quality

Tests were written for every new feature, to ensure better reliablity when changing or writing new code. Unittest were written using JUnit, and end-to-end tests using TestFX. We used Jacoco to check the code coverage. 
Our final code-coverage is at 92% for both rest and core module, and 74% for fxui module. 

Spotbugs were used to find potential bugs, or poor code. Fixes were issued after finding them using this tool. Checkstyle was also used to improve code quality. Currently, checkstyle shows a lot of errors. None of the errors are major, mostly consisting of incorrect indentations etc. 

<!-- We have meetings where we together map out what the project needs, based on the requirements of the next release, when we need it done and an estimate of when we should have the next meeting. We then structure the work thats needed by writing them as issues on Github, which are then delegated between us. Who gets which issues gets decided by trying to give everyone a fair share of work, while also trying to diversify everyones type of work throughout the project. The issues are made with tags which communicate what kind of work that needs to be done. We choose between testing, core, infrastructure, UI, documentation or bug after whats most fitting. In addition to writing a description of what the issue is about. We also choose what release of the project the issue is made for and who gets assigned to it. The assignee then creates a branch out of the issue, and starts working out of said branch. If the assignee gets stuck he can easily get help as theres a high tolerance for anyone to ask for help from the group. The branch is then requested to merge to the masterbranch when the issue is complete, after firstly being commited with a message saying what has been done. The branch gets reviewed by another in the group before being confirmed and merged. We have kept an efficient and structured workflow by using this system.

We use a varierity of tools to ensure that our code quality is high. We do so through writing tests, using jacoco, spotbugs and checkstyle. Our approach to writing tests is by first writing our code to near completion, and then writing tests to the equivalent code. We write test code that checks that everything we want the project to do gets done correctly, while everything outside that is either not possible for the user to do, or gives errors. The tests are created by going through every method or graphical function and planing how it should and shouldnt work. We then write tests based on this. We then check with jacoco to show if tests are missing and then return to writing tests until we are satified. Furthermore we use checkstyle and spotbugs. We have the file eclipse-java-google-style.xml that controls the settings for checkstyle and exclude.xml for spotbugs. The settings for checkstyle follow the standard formating of eclipse-java-google-style.xml. Exclude.xml is a filter file which can pick up instances of bugs based on their bug pattern, which then get excluded from the typical bug treatment.
 -->

## Reason for late submission 

We had to get a later deadline for the third release of the project. The main reason being that the amount of work on 3 people was alot. We are only 3 people in the group so tasks took a while since there was more work per person than in a group with 4 people. Especially making the project shippable proved to be quite hard and time consuming since we did not have any module-info.java files. There was also internal problems in the group that had to be dealt with. We belive the extended deadline would help us with showing our work and knowledge in a fair way. 