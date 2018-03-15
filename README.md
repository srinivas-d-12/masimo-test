# masimo-test
A command line tool for displaying matrix representation of floating point numbers

## Pre Requisites
#### Maven Installed
#### JDK 1.8 Version

## Installation
```
git clone https://github.com/srinivas-d-12/masimo-test.git
cd masimo-test
mvn clean package
```

## Running 
#### Running tests
```
mvn test
```
#### Running application 
``` 
java -jar ./target/masimo-test-1.0-SNAPSHOT-shaded.jar -f <Path to TEST.PRN> -c 4 -n 300

```
