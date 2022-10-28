package com.giandomenico.w5.d5.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.giandomenico.w5.d5.entities.Postazione;
import com.giandomenico.w5.d5.entities.Prenotazione;
import com.giandomenico.w5.d5.entities.User;
import com.giandomenico.w5.d5.repositories.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository pr;
	
	public List<Prenotazione> getAll() {
		return pr.findAll();
	}
	
	public void addPrenotazione(Prenotazione p) {
		pr.save(p);
	}
	
	public Prenotazione findPrenotazioneById(Long id){
        return pr.findById(id).isPresent() ? pr.findById(id).get() : null;
    }

	public void realAddPrenotazione(User u, Postazione p, LocalDate d){
        Prenotazione prenotazione = Prenotazione.builder().user(u).data(d).postazione(p).build();
        List<Prenotazione> list = pr.checkPrenotazione(u,d,p);
        if (list.size()==0){
            pr.save(prenotazione);
        }else{
            System.out.println("Non pupi POJOOOO!");
        }
    }
}
