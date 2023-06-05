package com.msbruno.controllers;

import org.apache.commons.lang3.StringUtils;

public class NumberConverter {

	public Double convert(String number) {
		number = treatParameter(number);
		return Double.valueOf(number);
	}

	public boolean isNumeric(String number) {
		number = treatParameter(number);
		return StringUtils.isNumeric(number);
	}
	
	private String treatParameter(String strNumber) {
		return strNumber.replace(',', '.');
	}
}
