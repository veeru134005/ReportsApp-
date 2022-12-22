package com.ashokit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ashokit.entity.Plans;

public interface PlanRepository extends JpaRepository<Plans, Integer> {

}
