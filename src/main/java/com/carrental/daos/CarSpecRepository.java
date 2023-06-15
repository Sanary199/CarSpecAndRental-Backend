package com.carrental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.carrental.entities.Car;
import com.carrental.entities.CarSpec;
import com.carrental.entities.SpecVariants;


@Repository
public interface CarSpecRepository extends JpaRepository<CarSpec, String>{
    //List<CarSpec> findBySpec(SpecVariants SpecVariants,String status);
	List<CarSpec> findByStatus(String status);

	Object findAllById(SpecVariants findById);

//	List<CarSpec> findAllById(SpecVariants findById, String status);

	

	

	
}
