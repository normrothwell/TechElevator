# The Full Stack Puppy

## **Introduction**

We have here an application with a Java back end and a VUE front end.

The Java back end application is located in the `puppyApp-server` folder. The back end server app is a Spring application with several REST controller endpoints. It is designed to handle GET, GET/n, POST, PUT, and DELETE requests. This back end app relies on a 
database called `puppies`. The instructions to setup the database are contained within the
`puppyApp-server` project as well.

The front end application is a VUE application, and it is located in the `puppyapp-vue` folder. This application consumes almost all the end points provided by the server app. In other words, it makes use of fetch to send GET, POST's, and PUT requests to the back end app. 

## **How To Run This?**

### 1. **Run the Back End Spring app**: 

Run the backend java application first. Open it in Eclipse and run it like any of the other Spring / Maven projects we have done in class. The back end requires a database, if you followed along during lecture 4-1, you should have it present. 

Ensure the application launches in port 8080.

### 2. **Run the Front End VUE app**:

Run the front end application through npm. If it's first time running it, you will need to run ```npm install```. The application is run with ```npm run serve```.