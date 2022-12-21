package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.entities.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, String>{

}
