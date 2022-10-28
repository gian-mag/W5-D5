package com.giandomenico.w5.d5.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.giandomenico.w5.d5.entities.Citta;
import com.giandomenico.w5.d5.entities.Postazione;
import com.giandomenico.w5.d5.entities.Tipo;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {
	@Query(
            value = "SELECT p FROM Postazione p WHERE p.tipo = :t AND p.edificio.citta = :c"
    )
    public List<Postazione> findPostazioneByTipoAndCitta( @Param( "t") Tipo t, @Param( "c" ) Citta c);
}
