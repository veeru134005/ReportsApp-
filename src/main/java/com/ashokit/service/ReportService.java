package com.ashokit.service;

import java.util.List;

import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;

public interface ReportService {

	public List<UserReports> dynamicSearch(SearchForm searchForm);
	
}
