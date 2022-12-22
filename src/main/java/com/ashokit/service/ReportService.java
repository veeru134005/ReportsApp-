package com.ashokit.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.ashokit.entity.Plans;
import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;

public interface ReportService {

	public List<UserReports> dynamicSearch(SearchForm searchForm);

	public List<Plans> getPlanNames();

	public List<String> getPlanStatus();
	
	void generatExcelReport(HttpServletResponse response, SearchForm searchForm) throws Exception;
	
}
