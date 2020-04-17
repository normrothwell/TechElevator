# Creating REST APIs in Java Exercise 

In this exercise you are going to create REST APIs in Java that can be called externally.

You will use Postman to test your APIs.

You are given a DAO with a set of C.R.U.D. methods for accessing the database:

- `List<Puppy> getPuppies()` - Returns a List of Puppy objects, one object for each puppy in the data base
- `Puppy getPuppy(int id)`   - Returns a single Puppy object from the database with the `id` specified
- `void savePuppy(Puppy puppyToSave)` - Adds the Puppy object passed to the database
- `void removePuppy(int id)` - Deletes a single Puppy from the database based on the `id` it is passed

## Setup the database

1. Open a terminal session and navigate to the folder:
   
       ```~/workspace/yourname-java/module-4/13-Creating-APIs/java/database```

2. Run the command:  `sh import-database.sh`   This will create the database and table you need for the exercise as well as populate the table and display it's contents.  

## Exercise

* Complete the `PuppiesController` given to handle the following API requests:

```
GET - /api/allPuppies - return all Puppies in the data base as an array of JSON objects
  
GET - /api/puppy/# - Returns the Puppy from the data based whose id matches the # specified as a JSON object
  
POST - /api/newPuppy - Add a Puppy to the database using the Puppy information in the API request
  
DELETE - /api/removePuppy/# - Delete the Puppy from the database whose id matches the # specified 
```

* Use Postman to execute HTTP requests to test your Controller.

* Consider completing and testing the `GET /allPuppies` feature first so you can use it to verify the `POST` and `DELETE` features are correct.  i.e. Use `/allPuppies` to see that the Puppy you added is in the database and the one you delete is gone.

_Remember:_
* Data is sent to the API in the querystring of the URL for a GET
* Data is sent to the API in the body of a POST request
* Header entries may be required for some requests.


