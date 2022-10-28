package com.giandomenico.w5.d5;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.giandomenico.w5.d5.entities.*;
import com.giandomenico.w5.d5.services.CittaService;
import com.giandomenico.w5.d5.services.EdificioService;
import com.giandomenico.w5.d5.services.PostazioneService;
import com.giandomenico.w5.d5.services.PrenotazioneService;
import com.giandomenico.w5.d5.services.UserService;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner{

	@Autowired
    UserService us;
    @Autowired
    CittaService cs;
    @Autowired
    EdificioService es;
    @Autowired
    PostazioneService ps;
    @Autowired
    PrenotazioneService prs;
	
	
	public static void main(String[] args) {
		SpringApplication.run(GestionePrenotazioniApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
//		insertUser(User.builder().username("Popin").nomeCompleto("Lavo Asciugo").email("popipopi@gmail.com").build());
//		insertCitta(Citta.builder().name("Toronto").build());
//        insertEdificio(Edificio.builder().name("Palazzo verde").address("Via vegas").citta(cs.findCittaById(1L)).build());
//        insertPostazione(Postazione.builder().tipo(Tipo.OPENSPACE).maxSize(60).description("lavoro").edificio(es.findEdificioById(1L)).build());
		System.out.println(ps.getPostazioneByTipoAndCitta(Tipo.OPENSPACE, cs.findCittaById((long) 1)));
		
	    realPrenotazione(us.findUserById(1L),ps.findPostazioneById(1L),LocalDate.now());
		
	}
	
	public void insertUser(User u){
        us.addUser(u);
    }
    public void insertCitta(Citta c){
        cs.addCitta(c);
    }
    public void insertEdificio(Edificio e){
        es.addEdificio(e);
    }
    public void insertPostazione(Postazione p){
        ps.addPostazione(p);
    }
//    public void insertPrenotazione(Prenotazione pr){
//        prs.addPrenotazione(pr);
//    }

    public void realPrenotazione(User u, Postazione p, LocalDate d){
            prs.realAddPrenotazione(u,p,d);
        }
}