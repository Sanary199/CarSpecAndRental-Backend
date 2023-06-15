package com.carrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrental.entities.Company;
import com.carrental.entities.SpecVariants;



@Repository
public interface SpecVariantsRepository extends JpaRepository<SpecVariants, Integer> {
	List<SpecVariants> findByCompany(Company company);
}
