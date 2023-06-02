package com.msbruno;

import org.apache.commons.lang3.StringUtils;
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
			@PathVariable(name = "param1") String param1,
			@PathVariable(name = "param2") String param2) {
		
		param1 = treatParameter(param1);
		param2 = treatParameter(param2);
		
		if (!AreNumeric(param1, param2)) {
			return Double.MAX_VALUE;
		}
		
		return Double.valueOf(param1) + Double.valueOf(param2);
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
