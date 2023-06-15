package com.carrental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carrental.daos.SpecVariantsRepository;
import com.carrental.entities.SpecVariants;
import com.carrental.models.SpecVariantsDTO;
import com.carrental.utils.StorageService;

@Service
public class SpecVariantsService {
	@Autowired private SpecVariantsRepository repo;
	@Autowired private CompanyService cservice;
	@Autowired private StorageService storageService;
	
	public void saveVariant(SpecVariantsDTO dto) {
		System.out.println(dto);
		SpecVariants variant=new SpecVariants();
		BeanUtils.copyProperties(dto, variant);
		String photo=storageService.store(dto.getPhoto());
		variant.setPhoto(photo);		
		repo.save(variant);
	}
	
	public void updateVariant(int id,SpecVariantsDTO dto) {
		SpecVariants variant=repo.getById(id);
		variant.setPrice(dto.getPrice());
		variant.setTitle(dto.getTitle());
		variant.setCompany(dto.getCompany());
		repo.save(variant);
	}
	
	public List<SpecVariants> listall(){
		return repo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public List<SpecVariants> listByCompany(int id){
		return repo.findByCompany(cservice.findById(id));
	}
	
	public void deleteVariant(int id) {
		repo.delete(repo.getById(id));
	}
	
	public SpecVariants findById(int id) {
		return repo.getById(id);
	}

}
