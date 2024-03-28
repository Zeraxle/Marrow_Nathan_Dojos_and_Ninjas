package com.nathanm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathanm.models.Ninja;
import com.nathanm.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository repo;
	
	public List<Ninja> getAll(){
		return repo.findAll();
	}
	
	public Ninja getOne(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Ninja create(Ninja ninja) {
        return repo.save(ninja);
	}
	
	
	public Ninja update(Ninja ninja) {
		return repo.save(ninja);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
		
	}
}
	
	
	
	
