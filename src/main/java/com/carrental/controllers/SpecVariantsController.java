package com.carrental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrental.models.SpecVariantsDTO;
import com.carrental.models.VariantDTO;
import com.carrental.services.SpecVariantsService;


@CrossOrigin
@RestController
@RequestMapping("/api/specvariants")
public class SpecVariantsController {
@Autowired private SpecVariantsService svservice;
	
	@PostMapping
	public ResponseEntity<?> save(SpecVariantsDTO dto) {		
		svservice.saveVariant(dto);
		return ResponseEntity.ok("Variant registered successfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> save(@PathVariable("id") int id, SpecVariantsDTO dto) {		
		svservice.updateVariant(id,dto);
		return ResponseEntity.ok("Variant updated successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(svservice.listall());
	}
	
	@GetMapping("company/{id}")
	public ResponseEntity<?> findAll(@PathVariable("id") int id) {		
		return ResponseEntity.ok(svservice.listByCompany(id));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(svservice.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		svservice.deleteVariant(id);
		return ResponseEntity.ok("Deleted successfully");
	}

}
