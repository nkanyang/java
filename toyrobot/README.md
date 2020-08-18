Toy Robot Simulator
===================

Problem Description
-----------
- A simple app simulating a toy robot moving on a tabletop of 5 units x 5 units.
- For more detaild information about the problem please check SOLUTION.md.

How To Run
-----------
The artifact "toyrobot-1.0.jar" of the simulator can be found in the zip package in direcotory bin. It can also be built from project(see: [Project Build, Test and Package](#project-build-test-and-package))

Run the jar file as below: it will show the help message

```
# java -jar toyrobot-1.0.jar 
Usage: java -jar toyrobot-1.0 <fileName> [options]

options: 
    -l, --log          Show log of the execution of the toy robot simulator
```
  

Take the command file bellow for example: the commands.txt is a text file contains a serial of command
  ```
# cat commands.txt 
PLACE 1,2,EAST
MOVE
MOVE
LEFT
MOVE
REPORT
```

Specify the file name (include path if not in the same directory) when invoke the app
```
# target java -jar toyrobot-1.0.jar commands.txt        
3,3,NORTH
```
  
Use "--log" or "-l" option if you want to get log about how the simulator works
```
# java -jar toyrobot-1.0.jar commands.txt -l
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: PLACE 1,2,EAST: Command executed successfully.
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: MOVE: Command executed successfully.
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: MOVE: Command executed successfully.
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: LEFT: Command executed successfully.
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: MOVE: Command executed successfully.
Aug 18, 2020 5:15:15 PM com.codetest.toyrobot.game.Game executeCommand
INFO: REPORT: Command executed successfully.
3,3,NORTH
```

Project Build, Test and Package
-----------
### Dependencies

- Project management tool: Maven
- JDK Version: Java 8
- Dependencies: JUnit 5, Mockito

### Build
compile the project
```
mvn compile
```

### Test
run all the tests (unit tests and integration tests)
```
mvn test
```

### Package
compile, run tests and build the artifact in ```./target/ ```
```
mvn package
```

Test Coverage
-----------

