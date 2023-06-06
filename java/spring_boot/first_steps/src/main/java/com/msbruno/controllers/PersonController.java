package com.msbruno.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msbruno.entities.Person;

@RestController
@RequestMapping(value  = "/person")
public class PersonController {

	@RequestMapping(value  = "/{id}",
			method = RequestMethod.GET)
	public Person getPerson(@PathVariable(name = "id") String id) {
		return new Person(1l, "eu", "sobrenome", "123123");
	}
}
