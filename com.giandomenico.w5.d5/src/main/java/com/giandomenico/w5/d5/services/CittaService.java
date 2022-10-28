package com.giandomenico.w5.d5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giandomenico.w5.d5.entities.Citta;
import com.giandomenico.w5.d5.repositories.CittaRepository;

@Service
public class CittaService {

	@Autowired
	CittaRepository cr;
	
	public List<Citta> getAll() {
		return cr.findAll();
	}
	
	public void addCitta(Citta c) {
		cr.save(c);
	}
	
	public Citta findCittaById(Long id){
        return cr.findById(id).isPresent() ? cr.findById(id).get() : null;
    }
}
