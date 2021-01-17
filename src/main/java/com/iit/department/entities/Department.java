package com.iit.department.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false)
	private Long id;

	@Basic(optional = false)
	@Column(nullable = false, length = 255)
	private String name;

	@Basic(optional = false)
	@Column(name = "no_of_employees", nullable = false, length = 100)
	private int noOfEmployees;

}
