package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ashokit.Repository.PlanRepository;
import com.ashokit.Repository.ReportRepository;
import com.ashokit.entity.Plans;
import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;

@Service
public class ServiceImpl implements ReportService {

	private static final SearchForm SearchForm = null;

	@Autowired
	private ReportRepository reportRepository;

	@Autowired
	private PlanRepository planRepo;

	@Override
	public List<UserReports> dynamicSearch(SearchForm searchForm) {

		String planName = searchForm.getPlanName();
		String planStatus = searchForm.getPlanStatus();
		
		UserReports user=new UserReports();

		if (!Optional.ofNullable(searchForm).isPresent() || (planName == null && planStatus == null) ||(planName.isBlank()&& planStatus.isBlank())) {
			
			//return reportRepository.findAll();
		} else if (searchForm.getPlanStatus() != null && (planName == null || planName.isBlank())) {
			user.setPlanStatus(planStatus);
			//return reportRepository.findAllByPlanStatus(planStatus);
		} else if (planName != null && (planStatus == null || planStatus.isBlank())) {
			user.setPlan(new Plans(1,planName));
			//return reportRepository.findAllByPlanName(planName);
		} else if (planName != null && searchForm.getPlanStatus() != null && !planStatus.isBlank() &&!planName.isBlank()) {
			user.setPlanStatus(planStatus);
			user.setPlan(new Plans(searchForm.getPlanId(),planName));
			//return reportRepository.findAllByPlanNameAndStaus(planName, planStatus);
		}

		return reportRepository.findAll(Example.of(user));
	}

	@Override
	public List<Plans> getPlanNames() {

		return planRepo.findAll();
	}

	@Override
	public List<String> getPlanStatus() {
		return reportRepository.getPlanStatus();
	}

	@Override
	public void generatExcelReport(HttpServletResponse response,SearchForm searchForm) throws Exception {

		HSSFWorkbook workbook=new HSSFWorkbook();
		
		HSSFSheet sheet = workbook.createSheet("Reports");
		
		HSSFRow row = sheet.createRow(0);
		
		row.createCell(0).setCellValue("UserId");
		row.createCell(1).setCellValue("Email");
		row.createCell(2).setCellValue("MobileNum");
		row.createCell(3).setCellValue("Gender");
		row.createCell(4).setCellValue("SSN");
		row.createCell(5).setCellValue("PlanStatus");
		
		List<UserReports> userData = dynamicSearch(searchForm);
		
		int startingIndex=1;
		
		for (UserReports report : userData) {
			System.out.println(report);
			HSSFRow dataRow = sheet.createRow(startingIndex);
			dataRow.createCell(0).setCellValue(report.getUserId());
			dataRow.createCell(1).setCellValue(report.getEmail());
			dataRow.createCell(2).setCellValue(report.getMobileNum());
			dataRow.createCell(3).setCellValue(report.getGender());
			dataRow.createCell(4).setCellValue(report.getSsn());
			dataRow.createCell(5).setCellValue(report.getPlanStatus());
			startingIndex++;
		}
		
			ServletOutputStream outputStream = response.getOutputStream();
			
			workbook.write(outputStream);
			workbook.close();
			outputStream.close();
	}
	
}
