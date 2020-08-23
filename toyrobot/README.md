Toy Robot Simulator
===================

Problem Description
-----------
- A command line application simulates a toy robot moving on a tabletop of 5 units x 5 units by taking a file of commands as input.
- For more detailed information about the problem, please check PROBLEM.md.


Project Build, Test and Package
-----------
### Dependencies

- Project management tool: Maven 3.6.3
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

### Artifact

- Build from source
  
The artifact "toyrobot.jar" can be found in target directory after running "mvn package".
- Unzip from tar
  
If you get a zip file, the artifacr can be found in the bin directory after unpacking it.

### Example

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
2020-08-21 15:13:06 INFO  root:41 - Begin parsing commands from file command.txt
2020-08-21 15:13:06 INFO  root:50 - PLACE 1,2,EAST is parsed successfully.
2020-08-21 15:13:06 INFO  root:50 - MOVE is parsed successfully.
2020-08-21 15:13:06 INFO  root:50 - MOVE is parsed successfully.
2020-08-21 15:13:06 INFO  root:50 - LEFT is parsed successfully.
2020-08-21 15:13:06 INFO  root:50 - MOVE is parsed successfully.
2020-08-21 15:13:06 INFO  root:50 - REPORT is parsed successfully.
2020-08-21 15:13:06 INFO  root:53 - Done parsing commands.
2020-08-21 15:13:06 INFO  root:55 - Start game, execute all commands ...
2020-08-21 15:13:06 INFO  Game:20 - PLACE 1,2,EAST: Command executed successfully.
2020-08-21 15:13:06 INFO  Game:20 - MOVE: Command executed successfully.
2020-08-21 15:13:06 INFO  Game:20 - MOVE: Command executed successfully.
2020-08-21 15:13:06 INFO  Game:20 - LEFT: Command executed successfully.
2020-08-21 15:13:06 INFO  Game:20 - MOVE: Command executed successfully.
3,3,NORTH
2020-08-21 15:13:06 INFO  Game:20 - REPORT: Command executed successfully.
```


