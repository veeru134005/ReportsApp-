package com.ashokit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashokit.Repository.ReportRepository;
import com.ashokit.entity.UserReports;
import com.ashokit.model.SearchForm;

@Service
public class ServiceImpl implements ReportService{

	@Autowired
	private ReportRepository reportRepository;
	
	@Override
	public List<UserReports> dynamicSearch(SearchForm searchForm) {
		
		String planName = searchForm.getPlanName();
		String planStatus = searchForm.getPlanStatus();

		if (!Optional.ofNullable(searchForm).isPresent() || (planName == null && planStatus == null)) {
			return reportRepository.findAll();
		} else if (searchForm.getPlanStatus() != null && (planName == null || planName.isBlank())) {
			return reportRepository.findAllByPlanStatus(planStatus);
		} else if (planName != null && (planStatus == null || planStatus.isBlank())) {
			return reportRepository.findAllByPlanName(planName);
		} else if (planName != null && searchForm.getPlanStatus() != null) {
			return reportRepository.findAllByPlanNameAndStaus(planName, planStatus);
		}

		return reportRepository.findAll();
	}

}
