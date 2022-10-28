package com.giandomenico.w5.d5.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.giandomenico.w5.d5.entities.Edificio;
import com.giandomenico.w5.d5.repositories.EdificioRepository;

@Service
public class EdificioService {

	@Autowired
	EdificioRepository er;
	
	public List<Edificio> getAll() {
		return er.findAll();
	}
	
	public void addEdificio(Edificio e) {
		er.save(e);
	}
	
	public Edificio findEdificioById(Long id){
        return er.findById(id).isPresent() ? er.findById(id).get() : null;
    }
	
}
