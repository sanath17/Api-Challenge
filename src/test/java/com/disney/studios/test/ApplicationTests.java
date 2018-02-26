package com.disney.studios.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.disney.studios.model.Breed;
import com.disney.studios.model.Dog;
/**
 * Please Uncomment and change the spring version to 4.0 to execute the following test
 * @author Sai-Sanath
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getAllBreedsTest() {
		ResponseEntity<Breed[]> responseEntity = restTemplate.getForEntity("/api/Breed/getAllBreeds", Breed[].class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(3, responseEntity.getBody().length);
	}

	@Test
	public void getBreedByNameTest() {
		final String url = "B1";
		ResponseEntity<Breed> responseEntity = restTemplate.getForEntity("/api/Breed/getBreedsBy/" + url, Breed.class);
		List<Dog> dogsInBreed = responseEntity.getBody().getDogs();
		System.out.println(dogsInBreed.size());
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(2, dogsInBreed.size());

	}

	@Test
	public void getAllDogs() {
		ResponseEntity<Dog[]> responseEntity = restTemplate.getForEntity("/api/Dog/getAllDogs", Dog[].class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(6, responseEntity.getBody().length);
	}

}
