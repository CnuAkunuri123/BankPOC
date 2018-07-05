# BankPOC using Spring Boot + Spring Security + Rest API

Example Spring Boot + Hibernate + Spring Security + Rest API project for demonstration purposes. 

## Getting started
### Prerequisites:
- Java 8
- Maven
- MYSQL

DataBase setup:
--------------
Uploaded the sql_script.sql file with the application.
1. open the file and run the scripts one by one in MYSQL Command Line
						Or
2. Open MySQL Workbench and in the “File” menu click on “Run SQL Script” and chose the SQL file location and click on Run 


Application Setup:
-----------------
1. Download the source code from git hub 
2. Run "mvn clean install" from App1 and App2.
3. Once both the spring boot jars generated. Go to the target folders of App1 and App2 project
4. Run the jars one by one using following commands:
	App1 -> target -> java -jar App1-0.0.1-SNAPSHOT.jar
	App2 -> target -> java -jar App2-0.0.1-SNAPSHOT.jar
	
5. App1 and App2 both applicaitons are running using embedded tomcat
	App1 -> tomcat port: 8090 ex:- http://localhost:8090/user/login
	App2 -> tomcat port: 8070 ex:- http://localhost:8070/bank/getAccount
	
Assumtions before run the application:
-------------------------------------
Both App1 & App2  are in same network for this POC
Both App1 database & App2 database are in same network for this POC
Data at rest is in-progress (like account number etc.) is not encrypted for POC

Future implementations ->
	HTTPS/TLS and OAuth Autentication for security
	

