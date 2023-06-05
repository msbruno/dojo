package com.msbruno;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.msbruno.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {

	@RequestMapping(
			value = "/sum/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double sum(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		param1 = treatParameter(param1);
		param2 = treatParameter(param2);
		
		if (!AreNumeric(param1, param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		
		return Double.valueOf(param1) + Double.valueOf(param2);
	}
	
	@RequestMapping(
			value = "/div/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double div(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		param1 = treatParameter(param1);
		param2 = treatParameter(param2);
		
		if (!AreNumeric(param1, param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		
		return Double.valueOf(param1) / Double.valueOf(param2);
	}
	
	@RequestMapping(
			value = "/sub/{param1}/{param2}",
			method=RequestMethod.GET)
	public Double subtration(
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		param1 = treatParameter(param1);
		param2 = treatParameter(param2);
		
		if (!AreNumeric(param1, param2)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		
		return Double.valueOf(param1) - Double.valueOf(param2);
	}
	
	@RequestMapping(
			value = "mult/{param1}/{param2}",
			method = RequestMethod.GET
			)
	public Double multiplication(
			@PathVariable(name="param1") String param1,
			@PathVariable(name="param2") String param2
			) {
		param1 = treatParameter(param1);
		param2 = treatParameter(param2);
		
		if (!AreNumeric(param1, param2)) {
			throw new UnsupportedMathOperationException("Please set a valid number to the parameters.");
		}
		return Double.valueOf(param1) * Double.valueOf(param2);
	}
	
	@RequestMapping(
			value = "squaredroot/{number}",
			method = RequestMethod.GET
			)
	public Double squaredRoot(@PathVariable(name="number") String number) {
		number = treatParameter(number);
		
		if (!AreNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a valid number to the parameters.");
		}
		return Math.sqrt(Double.valueOf(number));
	}

	private String treatParameter(String strNumber) {
		return strNumber.replace(',', '.');
	}

	private boolean AreNumeric(String... paramList) {
		for (String param : paramList) {
			if (!StringUtils.isNumeric(param)){
				return false;
			}
		}
		return true;
	}
}
