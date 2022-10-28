package com.giandomenico.w5.d5.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.giandomenico.w5.d5.entities.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, Long>{

}
