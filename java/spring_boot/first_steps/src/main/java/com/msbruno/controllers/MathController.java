package com.msbruno.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msbruno.controllers.exceptions.UnsupportedMathOperationException;
import com.msbruno.entities.Calculator;

@RestController
public class MathController {
	
	Calculator calc = new Calculator();
	NumberConverter converter = new NumberConverter();

	@RequestMapping(
			value = "/sum/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		if (!converter.isNumeric(param1) && !converter.isNumeric(param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		Double number1 = converter.convert(param1);
		Double number2 = converter.convert(param2);
		
		return calc.sum(number1, number2);
	}
	
	@RequestMapping(
			value = "/div/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double div(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		if (!converter.isNumeric(param1) && !converter.isNumeric(param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		Double number1 = converter.convert(param1);
		Double number2 = converter.convert(param2);
		
		return  calc.division(number1, number2);
	}
	
	@RequestMapping(
			value = "/sub/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double subtration(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		if (!converter.isNumeric(param1) && !converter.isNumeric(param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		Double number1 = converter.convert(param1);
		Double number2 = converter.convert(param2);
		
		return calc.subtract(number1 , number2);
	}
	
	@RequestMapping(
			value = "mult/{param1}/{param2}",
			method = RequestMethod.GET
			)
	public Double multiplication(
			@PathVariable(name="param1") String param1,
			@PathVariable(name="param2") String param2
			) {
		
		if (!converter.isNumeric(param1) && !converter.isNumeric(param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		Double number1 = converter.convert(param1);
		Double number2 = converter.convert(param2);
		return calc.multiplication(number1, number2);
	}
	
	@RequestMapping(
			value = "squaredroot/{param}",
			method = RequestMethod.GET
			)
	public Double squaredRoot(@PathVariable(name="param") String param) {
		
		if (!converter.isNumeric(param)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		Double number = converter.convert(param);
		return calc.squaredRoot(number);
	}
}
