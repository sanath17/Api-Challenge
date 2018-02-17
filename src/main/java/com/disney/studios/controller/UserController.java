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

import com.disney.studios.model.Dog;
import com.disney.studios.model.User;
import com.disney.studios.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Sanath 
 * 
 * Rest Controller {@link User} for getting the breed related data
 *         
 */

@RestController
@RequestMapping("/api/user")
@Api(value = "Dog Controller API", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
	@Autowired
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * This method Saves the  User
	 * @return
	 */
	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation("Save the User Data")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created", response = User.class) })
	public @ResponseBody ResponseEntity<User> saveBreed(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
		
	}
	
	
	/**
	 * This method returns the User Entity based on the UserName
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/getdogby/{userName}", method = RequestMethod.GET)
	@ApiOperation("Get User on a specific userName")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class) })
	public @ResponseBody User getUser(@PathVariable("userName") String userName) {

		return (User) userService.getByUsername(userName);

	}
	
	
	/**
	 * This method deletes the  user based on userName
	 * @return 
	 * @return
	 */
	@RequestMapping(value = "/deleteuser/{username}", method = RequestMethod.DELETE)
	@ApiOperation("Delte the user Data by using userName")
	@ApiResponses(value = { @ApiResponse(code = 204, message = "NoContent", response = Dog.class) })
	public @ResponseBody void deleteBreed(@PathVariable("username") String userName) {
		userService.deleteUser(userName);
		
	}


}
