package com.disney.studios.controller;

import java.util.List;

import javax.ws.rs.Consumes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.disney.studios.model.Dog;
import com.disney.studios.service.DogService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sanath 
 * 
 * Rest Controller {@link Dog} for getting the breed related data
 * 
 */
@RestController
@RequestMapping("/api/dog")
@Api(value = "Dog Controller API", produces = MediaType.APPLICATION_JSON_VALUE)

public class DogController {
	@Autowired(required = true)
	private DogService dogService;

	public void setDogService(DogService dogService) {
		this.dogService = dogService;
	}
	

	/**
	 * This method Saves the  Dog
	 * @return
	 */
	@RequestMapping(value = "/savedog", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save the Dog Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Dog.class) })
	public @ResponseBody ResponseEntity<Dog> saveBreed(@RequestBody Dog dog) {
		return new ResponseEntity<Dog>(dogService.saveDog(dog), HttpStatus.CREATED);
		
	}
	
	

	/**
	 * This method is to get the Dog based on the
	 * 
	 * @param dogId
	 *            and
	 * @return the Dog Object
	 */
	@RequestMapping(value = "/getdogby/{dogid}", method = RequestMethod.GET)
	@ApiOperation("Get Dog on a specific id")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Dog.class) })
	public @ResponseBody ResponseEntity<Dog> getDog(@PathVariable("dogId") int dogId) {
		Dog dog = dogService.getByDogId(dogId);
		return new ResponseEntity<Dog>(dog, HttpStatus.OK);

	}

	/**
	 * This method returns the list of all the dogs in the databse
	 * 
	 * @return
	 */
	@RequestMapping(value = "/getalldogs", method = RequestMethod.GET)
	@ApiOperation("Get all the dogs on votes of the dog")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Dog.class) })
	public @ResponseBody ResponseEntity<List<Dog>> getAllDogs() {
		List<Dog> dogs = dogService.getAllDogs();
		return new ResponseEntity<List<Dog>>(dogs, HttpStatus.OK);
	}
	
	
	/**
	 * This method deletes the  Dog
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/deletedog/{imageurl}", method = RequestMethod.DELETE)
	@ApiOperation("Delete the breed Data by image url")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "NoContent", response = Dog.class) })
	public @ResponseBody void deleteBreed(@PathVariable("imageurl") String imageUrl) {
		 dogService.deleteDog(imageUrl);
		
	}

}
