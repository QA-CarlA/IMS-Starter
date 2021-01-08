Coverage: 75%
# Project Title

The Inventory Management System allows the user to create, read, update and delete Customers, Items and Orders.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Java (Specifically Java 14) and Maven was used to develop this. 
To verify that java has been installed properly you can type "java -version" on the command line likewise with maven by typing "mvn -version" on the command line

```
Java (Java Version 14) - https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
Maven - https://maven.apache.org/
Git (not mandatory but makes it easier) - https://git-scm.com
```

### Installing
-The provided jar file only works with a local host database.

To start off, navigate to the directory that you want to place the folder (in my case its C:\Users\User\ProjectLocation) using git or the Command Prompt
If you don't have git installed then just download the zip file and extract it in the folder

If you have git installed
```
-Open Command Prompt-
cd Documents/ProjectLocation
OR
Right Click on ProgramLocation folder then press 'Git Bash here'
```

Copy the repository link and use 'git clone -insert link here-' 

```
C:\Users\User\ProjectLocation> git clone https://github.com/QA-CarlA/IMS-Starter.git
```

In order to run the jav file, find the IMS.jav file on the Documentation and move it in C:\Users\User\ProjectLocation\IMS-Starter
Then run the application by open the project folder in command prompt and run the jar file by typing

```
C:\Users\User\ProjectLocation> cd IMS-Starter
C:\Users\User\ProjectLocation\IMS-Starter> java -jar IMS.jav 
```

To use your own database, open the DBUtils class using and edit the DB_URL, DB_USER and DB_PASS to the url, username and password of your database.

## Running the tests

To be able to run the tests, open Command Prompt on the project folder then type 'mvn test'
```
C:\Users\User\ProjectLocation\IMS-Starter> mvn test
```

### Unit Tests 

Explain what these tests test, why and how to run them

```
Give an example
```

### Integration Tests 
Explain what these tests test, why and how to run them

```
Give an example
```

### And coding style tests

Explain what these tests test and why

```
Give an example
```

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Hat tip to anyone whose code was used
* Inspiration
* etc
