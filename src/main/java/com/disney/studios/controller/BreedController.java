package com.disney.studios.controller;

import java.util.ArrayList;
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

import com.disney.studios.model.Breed;
import com.disney.studios.service.BreedService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sanath
 * 
 *  Rest Controller {@link Breed} for getting the breed related
 *         data
 */
@RestController
@RequestMapping("/api/breed")
@Api(value = "Breed Controller API", produces = MediaType.APPLICATION_JSON_VALUE)
public class BreedController {
	@Autowired
	private BreedService breedService;

	public void setBreedService(BreedService breedService) {
		this.breedService = breedService;
	}

	/**
	 * This method Saves the  Breed
	 * @return
	 */
	@RequestMapping(value = "/savebreed", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save the breed Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Breed.class) })
	public @ResponseBody ResponseEntity<Breed> saveBreed(@RequestBody Breed breed) {
		return new ResponseEntity<Breed>(breedService.saveBreed(breed), HttpStatus.CREATED);
		
	}
	/**
	 * This method returns the list Of all Breeds and dogs in that breed
	 * @return
	 */
	@RequestMapping(value = "/getallbreeds", method = RequestMethod.GET)
	@ApiOperation("Get all the breeds and dogs in the breed")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Breed.class) })
	public ResponseEntity<List<Breed>> listAllBreeds() {
		List<Breed> breeds = new ArrayList<Breed>();

		breeds = breedService.getAllBreeds();

		return new ResponseEntity<List<Breed>>(breeds, HttpStatus.OK);
	}

	/**
	 * This method returns the breed entity of a particular breed
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/getbreedby/{breedname}", method = RequestMethod.GET)
	@ApiOperation("Get Breed by a specific breed name")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Breed.class) })
	public @ResponseBody ResponseEntity<Breed> getBreedbyName(@PathVariable("breedname") String name) {
		Breed breeds = breedService.getAllBreedsbyName(name);
		return new ResponseEntity<Breed>(breeds, HttpStatus.OK);

	}
	
	/**
	 * This method deletes the  Breed
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/deletebreed/{breedname}", method = RequestMethod.DELETE)
	@ApiOperation("Delete the breed by breedName")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "NoContent", response = Breed.class) })
	public @ResponseBody void deleteBreed(@PathVariable("breedname") String breedName) {
		 breedService.deleteBreed(breedName);
		
	}
	

}
