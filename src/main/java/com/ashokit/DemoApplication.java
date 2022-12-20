package com.ashokit;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashokit.Repository.ReportRepository;
import com.ashokit.entity.Plans;
import com.ashokit.entity.UserReports;

@SpringBootApplication
public class DemoApplication implements ApplicationRunner{

	@Autowired
	private ReportRepository reportRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Arrays.asList(new Plans(1,"Arogya"),new Plans(2,"vidya"),new Plans(3,"RetireYodyana"),new Plans(4,"sethu"));
		
		UserReports ur=new UserReports();
		
		
		ur.setPlan(new Plans(null,"Arogya"));
		ur.setEmail("harin@gmail.com");
		ur.setGender("male");
		ur.setMobileNum(850082);
		ur.setSsn(2545);
		ur.setUserId(1252);
		ur.setPlanStatus("Approved");
		ur.setName("raja");
		reportRepository.saveAndFlush(ur);
		
		UserReports ur2=new UserReports();
		ur2.setPlan(new Plans(null,"vidya"));
		ur2.setEmail("Veera@gmail.com");
		ur2.setGender("male");
		ur2.setMobileNum(9582);
		ur2.setSsn(26589);
		ur2.setUserId(2485);
		ur2.setPlanStatus("Denied");
		ur2.setName("Veera");
		reportRepository.save(ur2);
	
	}

}
