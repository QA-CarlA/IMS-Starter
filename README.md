Coverage: 78.1%
Jira Kanban - [Link](https://test20novsoft2.atlassian.net/secure/RapidBoard.jspa?rapidView=3&projectKey=PC&atlOrigin=eyJpIjoiYjJjM2ExODlkMzUwNDIyZGI2MjM5ODM1NDBkMjZmNTAiLCJwIjoiaiJ9)
# Project Title

The Inventory Management System allows the user to create, read, update and delete Customers, Items and Orders.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

Java (Specifically Java 14) and Maven was used to develop this. 
To verify that java has been installed properly you can type "java -version" on the command line likewise with maven by typing "mvn -version" on the command line

Java (Java Version 14) - [Link](https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html)

Maven - [Link](https://maven.apache.org/)

Git (not mandatory but makes it easier) - [Link](https://git-scm.com)

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

All the tests are located in the test folder.

### Unit Tests 

```
public void testCreate() 
  {
		final Customer created = new Customer(8L, "Fubuki", "Kurokami");
		assertEquals(created, DAO.create(created));
	}
```
The code above is part of the *CustomerDAOTest* which ensures that the CustomerDAO is connecting to the database and modifying the customer data. The snippet tests that a customer has been created

```
public void testCreate()
	{
		final String testName = "Poster";
		final Double testPrice = 19.99;
		final Long testStock = 100L;
		final Item created = new Item(testName, testPrice, testStock);
		
		Mockito.when(utils.getString()).thenReturn(testName);
		Mockito.when(utils.getDouble()).thenReturn(testPrice);
		Mockito.when(utils.getLong()).thenReturn(testStock);
		Mockito.when(dao.create(created)).thenReturn(created);
		
		assertEquals(created, controller.create());
		
		Mockito.verify(utils, Mockito.times(1)).getString();
		Mockito.verify(utils, Mockito.times(1)).getDouble();
		Mockito.verify(utils, Mockito.times(1)).getLong();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```
The code above is part of the *ItemControllerTest* and it uses Mockito which mocks the method. The snippet tests that the item is created.

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Carl Angeles** - *Continued work* -[QA-CarlA](https://github.com/QA-CarlA)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments
The project wouldn't be possible without the help of the QA Trainers that have taught me what I needed for this project.
