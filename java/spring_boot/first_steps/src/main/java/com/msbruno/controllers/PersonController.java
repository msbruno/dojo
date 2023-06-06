package com.msbruno.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msbruno.controllers.exceptions.UnsupportedMathOperationException;
import com.msbruno.entities.Person;
import com.msbruno.usecases.FindPersonUseCase;

@RestController
@RequestMapping(value  = "/person")
public class PersonController {

	@Autowired
	private FindPersonUseCase findPersonService;
	private NumberConverter numberConverter = new NumberConverter();
	
	@RequestMapping(value  = "/{id}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person find(@PathVariable(name = "id") String id) {
		
		if (!numberConverter.isNumeric(id)) {
			String msg = String.format("O id '%s' não é um formato numérico válido", id);
			throw new UnsupportedMathOperationException(msg);
		}
		
		return findPersonService.find(numberConverter.convertToLong(id));
	}
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll(){
		return findPersonService.findAll();
	}
}
