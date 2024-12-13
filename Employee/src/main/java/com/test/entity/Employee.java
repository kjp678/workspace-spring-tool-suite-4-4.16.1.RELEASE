package com.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="employees2")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//object=notEmpty
	//String = notBlank
	//numeric= notNull
	@NotNull @NotEmpty
	@Column(name="first_name")
	@Size(max=20, message="Name should be upto 20 characters")
	private String firstName;
	
	@NotNull
	@Column(name="last_name")
	@Size(max=20, message="Name should be upto 20 characters")
	private String lastName;
	
	@NotNull @Email
	@Size(min=5, message="Invalid Email Id")
	@Column(name="email_id")
	private String emailId;
	
		
}
