package com.msbruno.entities;

import java.io.Serializable;

public record Person (
		Long id, 
		String firstName, 
		String surname, 
		String phone) implements Serializable {
	
}
