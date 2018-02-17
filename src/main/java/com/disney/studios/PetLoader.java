package com.disney.studios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.disney.studios.model.Breed;
import com.disney.studios.model.Dog;
import com.disney.studios.repository.BreedRepository;
import com.disney.studios.repository.DogRepository;

/**
 * Loads stored objects from the file system and builds up the appropriate
 * objects to add to the data source.
 *
 * Created by fredjean on 9/21/15.
 */
@Component
public class PetLoader implements InitializingBean {
	// Resources to the different files we need to load.
	@Value("classpath:data/labrador.txt")
	private Resource labradors;

	@Value("classpath:data/pug.txt")
	private Resource pugs;

	@Value("classpath:data/retriever.txt")
	private Resource retrievers;

	@Value("classpath:data/yorkie.txt")
	private Resource yorkies;

	@Autowired
	DataSource dataSource;

	@Autowired
	BreedRepository breedRepository;

	@Autowired
	DogRepository dogRepository;

	/**
	 * Load the different breeds into the data source after the application is
	 * ready.
	 *
	 * @throws Exception
	 *             In case something goes wrong while we load the breeds.
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		loadBreed("Labrador", labradors);
		loadBreed("Pug", pugs);
		loadBreed("Retriever", retrievers);
		loadBreed("Yorkie", yorkies);
	}

	/**
	 * Reads the list of dogs in a category and (eventually) add them to the
	 * data source.
	 * 
	 * @param breed
	 *            The breed that we are loading.
	 * @param source
	 *            The file holding the breeds.
	 * @throws IOException
	 *             In case things go horribly, horribly wrong.
	 */
	private void loadBreed(String breed, Resource source) throws IOException {
		List<Dog> listOfDogs = new ArrayList<Dog>();
		Breed breedObject = new Breed();
		breedObject.setBreedName(breed);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				Dog dogObject = new Dog();

				dogObject.setImageUrl(line);
				dogObject.setBreed(breedObject);
				listOfDogs.add(dogObject);

			}
		}
		breedObject.setDogs(listOfDogs);
		breedRepository.save(breedObject);
		System.out.println(breedRepository.findAll().toString());
	}
}
