package com.msbruno.usecases;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.msbruno.entities.Person;

@Service
public class FindPersonUseCase {
	
	public final AtomicLong counter = new AtomicLong();
	public final Logger logger = Logger.getLogger(FindPersonUseCase.class.getName());
	
	public Person find(Long id) {
		return new Person(1l, "eu", "sobrenome", "123123");
	}
	
	public List<Person> findAll() {
		var result = new ArrayList<Person>();
		
		for (int i = 0; i < 6; i++) {
			var id = i +1l;
			result.add(new Person(id, "Person +" +i, " Surname", "123123"));
		}
		return result;
	}

	public Person create(Person person) {
		return person;
	}
}
