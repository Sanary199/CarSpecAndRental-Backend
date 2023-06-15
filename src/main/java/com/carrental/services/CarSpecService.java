package com.carrental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carrental.daos.CarSpecRepository;
import com.carrental.entities.Car;
import com.carrental.entities.CarSpec;
import com.carrental.models.CarSpecDTO;

@Service
public class CarSpecService {
	@Autowired private CarSpecRepository crepo;
	@Autowired private SpecVariantsService svsrv;
	
	public void saveCarspec (CarSpecDTO dto) {
		CarSpec car = new CarSpec();
		if(crepo.existsById(dto.getId())){			
			car=crepo.getById(dto.getId());
		}		
		BeanUtils.copyProperties(dto, car);
		car.setSpecVariants(svsrv.findById(dto.getVarid()));
		crepo.save(car);
	}
	
	public void updateCar(CarSpec bk) {
		crepo.save(bk);
	}
	
	public List<CarSpec> listAll(){
		return crepo.findAll(Sort.by(Direction.DESC, "createdon"));
	}
	
	public CarSpec findById(String id) {
		return crepo.getById(id);
	}
	
	public List<CarSpec> specfilterCars(int id){
		System.out.println("Filter id "+id);
		if(id==1)
			return crepo.findByStatus("Available");
		else
			return crepo.findByStatus("Not Available");
	}
	
//	public List<CarSpec> listSpecVariantCars(int id){
//		return crepo.findBySpecVariants(svsrv.findById(id),"Available");
//	}

	
	public void deleteCarSpec(String id) {
		if(crepo.existsById(id)) {
			crepo.delete(crepo.getById(id));
		}
	}

	public Object listSpec(int varid) {
		// TODO Auto-generated method stub
		return crepo.findAllById(svsrv.findById(varid));
	}

//	public List<Car> listVariantBikes(int varid){
//		return crepo.findByVariantAndStatus(svsrv.findById(varid),"Available");
//	}

}
