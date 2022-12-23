package com.ashokit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashokit.entity.Plans;
import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;
import com.ashokit.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	private ReportService repSer;

	@PostMapping("/search")
	public List<UserReports> fetchDataBySearch(@RequestBody SearchForm searchForm) {
		return repSer.dynamicSearch(searchForm);
	}

	@GetMapping("/planName")
	public List<Plans> getPlanNames() {
		return repSer.getPlanNames();
	}

	@GetMapping("/planstatus")
	public List<String> getPlanStatus() {
		return repSer.getPlanStatus();
	}
	
	//@GetMapping("/excel")
	@PostMapping("/excel")
	public void generateExcelReport(@RequestBody SearchForm searchForm, HttpServletResponse response) throws Exception {
//		@RequestBody SearchForm searchForm, 
		response.setContentType("application/octet-stream");
		
		String hdrKey="Content-Disposition";
		String hdrValue="attachment;filename=exelreport.xls";
		
		response.setHeader(hdrKey,hdrValue);
		repSer.generatExcelReport(response, searchForm);
		//repSer.generatExcelReport(response, new SearchForm());
		
		response.flushBuffer();
	}
	
	//@GetMapping("/pdf")
	@PostMapping("/pdf")
	public void generatPdfReport(@RequestBody SearchForm searchForm, HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		
		String hdrKey="Content-Disposition";
		String hdrValue="attachment;filename=PDFreport.pdf";
		response.setHeader(hdrKey,hdrValue);
		
		repSer.generatPDFReport(response, searchForm);
		
		response.flushBuffer();
	}
}
