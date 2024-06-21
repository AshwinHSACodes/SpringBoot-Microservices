package com.eam.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long empid;
	
	@Column
	private String firstName;
	
	@Column
	private String lastName;
	
	@Column
	private String emailid;
	
	@Column
	private String address;
	
	@Column
	private String mobileno;
	
	@Column
	private String userName;
	
	@Column
	private String passWord;
}
