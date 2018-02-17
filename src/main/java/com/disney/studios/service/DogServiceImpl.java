package com.disney.studios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disney.studios.dao.DogDao;
import com.disney.studios.exception.DogNotFoundException;
import com.disney.studios.model.Dog;

/**
 * This class is service layer for DOg Entity 
 * Implemenntation of Dog Service interface
 * 
 * @author Sanath
 *
 */
@Service
public class DogServiceImpl implements DogService {

	@Autowired
	private DogDao dogDao;

	@Override
	public Dog getByDogId(int id) {
		Dog d = dogDao.getDogByID(id);
		d.setCount(d.getUserdoglikes().size());
		d.setDogBreed(d.getBreed().getBreedName());

		return d;
	}

	@Override
	public List<Dog> getAllDogs() {
		List<Dog> dogs = dogDao.getAllDogs();

		for (Dog d : dogs) {
			d.setCount(d.getUserdoglikes().size());
			d.setDogBreed(d.getBreed().getBreedName());
		}
		dogs.sort(new DogComparator());
		return dogs;
	}

	@Override
	public Dog getDogByImageUrl(String imageurl) {
		Dog existing = (Dog) dogDao.getByImageUrl(imageurl);
		if(existing == null){
			throw new DogNotFoundException("Dog with " + imageurl + "not found");
		}
		return existing;
	}

	@Override
	public Dog saveDog(Dog dog) {
		
		return dogDao.saveDog(dog);
				
	}

	@Override
	public void deleteDog(String imageurl) {
		Dog existing = (Dog) dogDao.getByImageUrl(imageurl);
		if(existing == null){
			throw new DogNotFoundException("Dog with " + imageurl + "not found");
		}
		 dogDao.deleteDog(imageurl);
	}

}
