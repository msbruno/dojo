package com.msbruno.usecases;

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
	
	
}
