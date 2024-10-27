# sbreackets2
Task 4 SB challenge: transaction service on Spring.

**Features:**
- [x] Performance Optimization:
    - [x] Inefficient data structures are replaced (array list -> concurrent hash map with soft references) and algorithms are optimized
    - [x] Code duplication is eliminated
    - [x] Memory usage is improved
- [x] Code refactoring:
    - [x] Duplicate elements are put into separate methods or classes
    - [x] The structure of the code is refactored to improve its readability and ease of support
- [x] Memory Management:
    - [x] Memory leaks are found and fixed (cache problems)
    - [x] Design patterns are used
- [x] Exception Handling:
    - [x] System can continue to work in case of errors
    - [x] Centralized error logging

**Technologies:**
- Java 17
- Gradle
- Spring Boot
- JUnit 5
- Mockito

**App starting**

Run the next command from root directory to build and start program ():
- Unix:
```
sudo gradlew clean build bootRun
```
- Windows:
```
./gradlew clean build bootRun
```


**App using and documentation**
* An app will be started on `8080 port`
