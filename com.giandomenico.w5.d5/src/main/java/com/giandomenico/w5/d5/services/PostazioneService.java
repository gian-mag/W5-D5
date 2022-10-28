package com.giandomenico.w5.d5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giandomenico.w5.d5.entities.Citta;
import com.giandomenico.w5.d5.entities.Postazione;
import com.giandomenico.w5.d5.entities.Tipo;
import com.giandomenico.w5.d5.repositories.PostazioneRepository;

@Service
public class PostazioneService {
	
    @Autowired
    PostazioneRepository prr;

    public List<Postazione> getAll() {
		return prr.findAll();
	}
	
    public void addPostazione(Postazione p){
        prr.save(p);
    }

    public Postazione findPostazioneById(Long id){
        return prr.findById(id).isPresent() ? prr.findById(id).get() : null;
    }
    
    public List<Postazione> getPostazioneByTipoAndCitta( Tipo t, Citta c) {
    	return prr.findPostazioneByTipoAndCitta(t, c);
    }
    
}