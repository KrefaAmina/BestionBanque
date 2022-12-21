package com.example.banque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.banque.entities.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
