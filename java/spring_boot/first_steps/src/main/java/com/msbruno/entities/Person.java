package com.msbruno.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public record Person (
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		Long id, 
		@Column(name = "name", length = 80)
		String firstName,
		@Column(name = "surname", length = 80)
		String surname,
		@Column(name = "phone", length = 80)
		String phone) implements Serializable {
	
}
