package com.disney.studios.controller;

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

import com.disney.studios.model.Userdoglike;
import com.disney.studios.service.UserDogLikeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/vote")
@Api(value = "UserDogLike Controller API", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserdoglikeController {

	@Autowired(required = true)
	private UserDogLikeService userDogLikeService;

	/**
	 * @author Sanath
	 * 
	 * This method saves the user like for a dog based on the below parameters
	 * returns null value if the dog is Once liked by user
	 * 
	 * @param username
	 * @param imageurl
	 * @param isLike
	 * @return
	 */
	@RequestMapping(value = "/savevote/{username}/{imageurl}/{isLike}", method = RequestMethod.POST)
	@ApiOperation("Return null if the dog is liked previoulsy by user if not save the dog with the parameters ")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = Userdoglike.class) })
	public @ResponseBody ResponseEntity<Userdoglike> addUserlike(@PathVariable("username") String username,
			@PathVariable("imageurl") String imageurl, @PathVariable("isLike") Boolean isLike) {

		Userdoglike userDog = userDogLikeService.saveDogLike(username, imageurl, isLike);
		if (userDog == null) {
			return new ResponseEntity<Userdoglike>(userDog, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Userdoglike>(userDog, HttpStatus.OK);

	}

	/**
	 * This method update the user like for a dog based on the below parameters
	 * if the value of the user and dog exists in the table otherwise null
	 * 
	 * @param username
	 * @param imageurl
	 * @param isLike
	 * @return
	 */
	@RequestMapping(value = "/updatevote/{username}/{imageurl}/{isLike}", method = RequestMethod.PUT)
	@ApiOperation("update the dog like based on the user input parameters")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Userdoglike.class) })
	public @ResponseBody ResponseEntity<Userdoglike> updateUserlike(@PathVariable("username") String username,
			@PathVariable("imageurl") String imageurl, @PathVariable("isLike") Boolean isLike) {

		Userdoglike userDog = userDogLikeService.updateDogLike(username, imageurl, isLike);
		if (userDog == null) {
			return new ResponseEntity<Userdoglike>(userDog, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Userdoglike>(userDog, HttpStatus.OK);

	}

	/**
	 * This method saves the user like for a dog if the userDogLike object is
	 * given
	 * 
	 * @param userDogLike
	 * @return
	 */
	@RequestMapping(value = "/savevote", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Check the dog is liked by user or not and save it on users input")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "created", response = Userdoglike.class) })
	public @ResponseBody ResponseEntity<Userdoglike> saveUserlike(@RequestBody Userdoglike userDogLike) {
		String userName = userDogLike.getUser().getUserName();
		String imageUrl = userDogLike.getDog().getImageUrl();
		boolean isLike = userDogLike.getIsLike();
		Userdoglike userDog = userDogLikeService.saveDogLike(userName, imageUrl, isLike);
		return new ResponseEntity<Userdoglike>(userDog, HttpStatus.CREATED);

	}

}
