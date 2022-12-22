package com.ashokit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchForm {
	
	private String planName;
	private String planStatus;
	private Integer planId;
	//private Date startDate;
	//private Date endDate;

}
