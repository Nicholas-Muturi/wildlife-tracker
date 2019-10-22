# Wildlife Tracker
##### By Nicholas M

## Description
Wildlife Tracker is a project that allows the user to report sightings of animals in a given location and provide additional information such as the health and the 'endangerment level' of the animal. Users who post are automatically registered as rangers and they can view their information by clicking on their names (inside the table) or simply clicking the "all rangers" link on the navigation panel

##### Object Properties
In this project we shall be dealing with 3 objects namely Ranger, Animal and Sighting. Below are the properties of each of the objects.
+ Animals: An ID, name, health, age, status (endangerment level)  
+ Sighting: An ID, animal sighted, location where it was sighted, the time it was seen and the ranger who saw it.
+ Ranger: A ranger id and the ranger's name.

## Prerequisites
1. PostgreSQL
2. Java JDK
3. Gradle
4. Git
5. Some prior knowledge of Java
6. Some prior knowledge of Spark framework
7. (optional) Java IDE

## Built With
1. HTML + Handlebars/Moustache
2. Css
3. Java
4. Gradle
5. Spark
6. Junit for testing
7. PostgreSQL for data storage

## Setup Guide
##### PostgreSQL
###### Installation
+ Run `sudo apt-get install postgresql postgresql-contrib libpq-dev` in the terminal to install PostgreSQL in your device.
+ Enter y when prompted `Do you want to continue? [Y/n]` and wait for the installation to complete.
+ Create your own credentials with superuser capabilities with the same name as our login name by running `sudo -u postgres createuser --superuser $USER`
+ Next, we’ll have to create a database with the same name as our login name by running `sudo -u postgres createdb $USER`
+ Finally run `psql` in the terminal to connect to the server
###### Structure
+ After running the `psql` command to connect to the server, proceed to create the database wildlife-tracker by executing the following command: `create database wildlife_tracker;`
+ Follow it up with this following command to connect to the newly created database`\c wildlife_tracker;`
+ Once connected, create 3 tables for each object stated above. Below are the commands to be executed:  
```
CREATE TABLE rangers(id serial PRIMARY KEY, name varchar);
CREATE TABLE animals(id serial PRIMARY KEY, name varchar, health varchar, age varchar, type varchar);
CREATE TABLE sightings(id serial PRIMARY KEY, animalname varchar, location varchar, timestamp timestamp, rangerid int);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;
```
+ The last command creates the test database that shall be used to run your tests on. insert `\q` to exit psql server.

##### Java
+ Run `java --version` to check which version of java you have installed in your device. If you have java installed, you should see an output slightly similar to the one below...  
_**openjdk 10.0.2 2018-07-17**_  
_**OpenJDK Runtime Environment (build 10.0.2+13-Ubuntu-1ubuntu0.18.04.4)**_  
 ... then you need to install java by running this : `sudo apt install default-jre`

+ Clone the repository into a desired folder by running the following link in your terminal: `https://github.com/Nicholas-Muturi/wildlife-tracker.git`

###### (for users with an IDE such as IntelliJ)
+ Open the project using the IDE you have installed
+ Build and Run the project.

###### (for users without an IDE)
+ Navigate to the folder containing the project
+ Build the gradle by running: `gradle build`.
+ Compile the code by running: `gradle compileJava`
+ Navigate to the App class file located at build/classes/java/main and run: `java App`.

## Live Link
[Visit the live link](https://sacred-jungle-0047.herokuapp.com/)

## License
This projects has a MIT License [found here](LICENSE)