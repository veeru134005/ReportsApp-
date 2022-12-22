package com.ashokit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "plans")
@AllArgsConstructor
@NoArgsConstructor
public class Plans {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	private String planName;
	
	

}
