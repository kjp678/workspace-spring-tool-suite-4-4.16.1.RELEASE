package com.crud.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="productTable")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long productId;
	
	@NotNull
	@Column(length =50)
	@Size(max = 50,min=2, message = "Must be between {max} and {min} ")
	private String productName;
	
	@Digits(fraction = 2, integer = 10, message="Please enter numbers, must be between ")
	private float price;
	
	@NotNull
	private Blob image;
}
