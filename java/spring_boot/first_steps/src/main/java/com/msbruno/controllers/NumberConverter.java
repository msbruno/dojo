package com.msbruno.controllers;

import org.apache.commons.lang3.StringUtils;

import com.msbruno.controllers.exceptions.UnsupportedMathOperationException;

public class NumberConverter {

	public Double convert(String number) {
		number = treatParameter(number);
		
		if (!StringUtils.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please, set a numeric value as param.");
		}
		return Double.valueOf(number);
	}
	
	private String treatParameter(String strNumber) {
		return strNumber.replace(',', '.');
	}
}
