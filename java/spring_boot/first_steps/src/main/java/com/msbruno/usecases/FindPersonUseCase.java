package com.msbruno.usecases;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msbruno.controllers.exceptions.ResourceNotFoundException;
import com.msbruno.entities.Person;
import com.msbruno.entities.PersonRepository;

@Service
public class FindPersonUseCase {
	
	public final AtomicLong counter = new AtomicLong();
	public final Logger logger = Logger.getLogger(FindPersonUseCase.class.getName());
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person find(Long id) {
		return this.personRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("id Não encontrado"));
	}
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}
}
