package com.ashokit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;
import com.ashokit.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	private ReportService repSer;
	
	@PostMapping("/search")
	public List<UserReports> fetchDataBySearch(@RequestBody SearchForm searchForm){
		return repSer.dynamicSearch(searchForm);
	}
	
}
