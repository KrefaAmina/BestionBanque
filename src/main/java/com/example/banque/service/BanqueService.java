package com.example.banque.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.banque.entities.Compte;
import com.example.banque.repository.CompteRepository;


import jakarta.transaction.Transactional;

@Service
@Transactional
public class BanqueService {
	
	@Autowired
	private CompteRepository compteRepository;

	

	
	public Compte consulterCompte(String num_Comp) {
		Optional<Compte> compte = compteRepository.findById(num_Comp);
		if(compte==null) {
			throw new RuntimeException("Le compte que vous avez saisi est introuvable.");
		}
		return compte.get();
	}




	public void delete(String num_Comp) {
		Optional<Compte> compte = compteRepository.findById(num_Comp);
		compte.ifPresent(compteRepository::delete);
		
	}


}
