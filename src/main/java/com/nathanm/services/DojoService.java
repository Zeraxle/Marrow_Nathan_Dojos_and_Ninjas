package com.nathanm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nathanm.models.Dojo;
import com.nathanm.repositories.DojoRepository;

@Service
public class DojoService {

	@Autowired
	DojoRepository repo;
	
	public List<Dojo> getAll(){
		return repo.findAll();
	}
	
	public Dojo getOne(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Dojo create(Dojo dojo) {
        return repo.save(dojo);
	}
	
	
	public Dojo update(Dojo dojo) {
		return repo.save(dojo);
	}
	
	public void destroy(Long id) {
		repo.deleteById(id);
	}
}
