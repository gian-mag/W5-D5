package com.giandomenico.w5.d5.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giandomenico.w5.d5.entities.Postazione;
import com.giandomenico.w5.d5.entities.Prenotazione;
import com.giandomenico.w5.d5.entities.User;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

	@Query(
            value = "SELECT p FROM Prenotazione p WHERE (p.user = :u AND p.data = :d) OR (p.postazione = :p AND " +
                    "p.data= :d)"
    )
    public List<Prenotazione> checkPrenotazione(@Param( "u" ) User u, @Param( "d" ) LocalDate d,
                                                     @Param( "p" ) Postazione p);
}
