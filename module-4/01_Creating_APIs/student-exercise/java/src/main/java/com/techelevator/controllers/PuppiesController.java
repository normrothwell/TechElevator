package com.techelevator.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techelevator.daos.PuppyDao;
import com.techelevator.exceptions.PuppyNotFoundException;
import com.techelevator.models.Puppy;

/**
 * Puppies API Controller
 * 
 * This controller should handle the following API requests:
 * 
 * GET - /api/allPuppies - return all Puppies in the data base as an array of JSON objects
 * 
 * GET - /api/puppy/# - Returns the Puppy from the data based whose id matches the # specified
 * 
 * POST - /api/newPuppy - Add a Puppy to the database using the Puppy information in the API request
 * 
 * DELETE - /api/removePuppy/# - Delete the Puppy from the database whose id matches the # specified 
 * 
 */

@RestController
@CrossOrigin
@RequestMapping("/api/allPuppies")
public class PuppiesController {
	
	@Autowired
	PuppyDao thePuppies;
	

	public PuppiesController(PuppyDao thePuppies) {
	
		this.thePuppies = thePuppies;
	}

	@GetMapping
	public List <Puppy> list() {
		return thePuppies.getPuppies();
	}
	
	@GetMapping("/puppy/{id}")
	public Puppy read(@PathVariable int id) {
		Puppy thePuppy = thePuppies.getPuppy(id);
		return thePuppy;
	}
	
	@PostMapping("/newPuppy")
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@RequestBody Puppy thePuppy) {
		thePuppies.savePuppy(thePuppy);
	}
	
	@DeleteMapping ("/removePuppy/{id}")
	public void delete(@PathVariable int id) {
		Puppy goodDog = thePuppies.getPuppy(id);
		if (goodDog != null) {
			thePuppies.removePuppy(id);
		}else {
			throw new PuppyNotFoundException("id not found");
		}
	}

}
