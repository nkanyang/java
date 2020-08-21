Toy Robot Simulator
===================

Problem Description
-----------
- A simple app simulating a toy robot moving on a tabletop of 5 units x 5 units.
- For more detaild information about the problem please check PROBLEM.md.


Project Build, Test and Package
-----------
### Dependencies

- Project management tool: Maven
- JDK Version: Java 8
- Dependencies: JUnit 5, Mockito, log4j

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

How To Run
-----------
The artifact "toyrobot.jar" of the simulator can be found in the zip package in direcotory bin. It can also be build in project( in directory target)

Run the jar file as below: it will show the help message

```
# java -jar toyrobot.jar 
Usage: java -jar toyrobot <fileName> [options]

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
# java -jar toyrobot.jar commands.txt        
3,3,NORTH
```
  
Use "--log" or "-l" option if you want to get log about how the simulator works
```
# java -jar toyrobot.jar commands.txt -l
2020-08-18 21:13:18 INFO  root:41 - Begin parsing commands from file /Users/jessie/toyrobot/commands.txt
2020-08-18 21:13:18 INFO  root:50 - PLACE 1,2,EAST is parsed successfully.
2020-08-18 21:13:18 INFO  root:50 - MOVE is parsed successfully.
2020-08-18 21:13:18 INFO  root:50 - MOVE is parsed successfully.
2020-08-18 21:13:18 INFO  root:50 - LEFT is parsed successfully.
2020-08-18 21:13:18 INFO  root:50 - MOVE is parsed successfully.
2020-08-18 21:13:18 INFO  root:50 - REPORT is parsed successfully.
2020-08-18 21:13:18 INFO  root:53 - Done parsing commands.
2020-08-18 21:13:18 INFO  root:55 - Start game, execute all commands ...
2020-08-18 21:13:18 INFO  Game:26 - PLACE 1,2,EAST: Command executed successfully.
2020-08-18 21:13:18 INFO  Game:26 - MOVE: Command executed successfully.
2020-08-18 21:13:18 INFO  Game:26 - MOVE: Command executed successfully.
2020-08-18 21:13:18 INFO  Game:26 - LEFT: Command executed successfully.
2020-08-18 21:13:18 INFO  Game:26 - MOVE: Command executed successfully.
3,3,NORTH
2020-08-18 21:13:18 INFO  Game:26 - REPORT: Command executed successfully.
```

Test Coverage
-----------
to be added ....
