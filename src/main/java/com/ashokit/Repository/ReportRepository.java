package com.ashokit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ashokit.entity.UserReports;

public interface ReportRepository extends JpaRepository<UserReports, Integer> {

	@Query("from UserReports where planStatus=:planStatus")
	public List<UserReports> findAllByPlanStatus(@Param("planStatus") String planStatus) ;
	
	@Query("select r from UserReports r join r.plan p where p.planName=:planName")
	public List<UserReports> findAllByPlanName(@Param("planName") String planName);
	
	@Query("select r from UserReports r join r.plan p where p.planName=:planName and r.planStatus=:planStatus")
	public List<UserReports> findAllByPlanNameAndStaus(@Param("planName") String planName,@Param("planStatus") String planStatus);
}
