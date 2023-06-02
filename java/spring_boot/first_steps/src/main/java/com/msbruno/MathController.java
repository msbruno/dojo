package com.msbruno;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

	@RequestMapping(
			value = "/sum/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(name = "param1") Double param1,
			@PathVariable(name = "param2") Double param2) {
		return param1 + param2;
	}
}
