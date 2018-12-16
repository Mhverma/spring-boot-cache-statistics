package com.manoj.training.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Book {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("name")
	private String name;
	
	
}
