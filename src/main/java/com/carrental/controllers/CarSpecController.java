package com.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.models.CarSpecDTO;
import com.carrental.services.CarSpecService;

@CrossOrigin
@RestController
@RequestMapping("/api/carspec")
public class CarSpecController {
@Autowired private CarSpecService cservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody CarSpecDTO dto) {		
		cservice.saveCarspec(dto);
		return ResponseEntity.ok("Car saved successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(cservice.listAll());
	}
	
//	@GetMapping("specvariants/{id}")
//	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
//		return ResponseEntity.ok(cservice.listVariantBikes(id));
//	}
	@GetMapping("specvariants/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id){
		return ResponseEntity.ok(cservice.listSpec(id));
	}
	
	@GetMapping("search")
	public ResponseEntity<?> findById(String id) {		
		return ResponseEntity.ok(cservice.findById(id));
	}
	
	@GetMapping("specfilter/{id}")
	public ResponseEntity<?> filterByStatus(@PathVariable("id") int id) {		
		return ResponseEntity.ok(cservice.specfilterCars(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		System.out.println(id);
		cservice.deleteCarSpec(id);
		return ResponseEntity.ok("Car deleted successfully");
	}

}
