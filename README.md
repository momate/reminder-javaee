# Reminder App #

## About ##
I created this project to learn more about Servlets, Application servers, basic front end technologies, web app deployment and some other related technologies.
I will further develop the project as I learn more techniques and concepts.The core technology will be remain the Servlet.

The application itself is a reminder taking app with the basic features, such as:

- Registering a User entity
- CRUD operations on the Reminder entity
- Adding a schedule for the reminder
- Sending an email to the user's email address with the reminder values

If you want to see the email, please use a valid email addres for the User entity.

## Technologies ##

* Maven
* JPA
* Servlets
* JSP
* JSTL
* Java Mail -> MailJet
* PostgreSQL/MySQL
* Payara Micro
* SLF4J - Log4J2
* JUnit5 - Mockito

## Setup and Run ##

Data source:

The data-source definition in the web.xml file contains:

```
        <class-name>${ENV=JDBC_DRIVER}</class-name>
        <server-name>${ENV=JDBC_HOST}</server-name>
        <database-name>${ENV=JDBC_DBNAME}</database-name>
        <user>${ENV=JDBC_USER}</user>
        <password>${ENV=JDBC_PASSWORD}</password>

```
Create a file called .env and put it in your project's "root", you need to have the same variable name as above. These will be replaced on deployment.
```
	JDBC_DRIVER=...
	JDBC_HOST=..
	JDBC_DBNAME=...
	JDBC_USER=...
	JDBC_PASSWORD=...
	
```
This file will only be read when you run Heroku in your local environment.

Set Email properties:

To use the email sending function, you need to have a MailJet account and it's api and secret key. Add these to the .env file too.


```
	MAILJET_SECRET_KEY=...
	MAILJET_API_KEY=...
```

#### Deploy with Heroku Local ####

In this case, I assume you have installed Heroku CLI in your machine.
From the command line, execute the following command:

```
 mvn clean package -Pdist  
```
```
 heroku local web -f Procfile.local
```

First line is compile the project, and uses the profile named 'dist', and then the second line runs the local heroku.

#### Deploy without Heroku ####

Change dircetly the values in the web.xml file based on the data source example above.
Currently the MailJet keys have to be set as environment variable. That will be change later.
Download and put the payara-micro.jar file in your project directory, and deploy with this command line:
```
java -jar payara-micro.jar --deploy <path-to-your-war-file>
```

