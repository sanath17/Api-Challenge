package com.disney.studios.service;

import java.util.Comparator;

import com.disney.studios.model.Dog;

public class DogComparator implements Comparator<Dog> {

	@Override
	public int compare(Dog arg0, Dog arg1) {

		return arg0.getCount() - arg1.getCount();
	}

}
