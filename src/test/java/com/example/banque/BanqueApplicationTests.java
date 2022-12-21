package com.example.banque;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.banque.entities.Client;
import com.example.banque.entities.Compte;
import com.example.banque.entities.Courant;
import com.example.banque.entities.Epargne;
import com.example.banque.repository.ClientRepository;
import com.example.banque.repository.CompteRepository;

@SpringBootTest
class BanqueApplicationTests {
	
	@Autowired
	private CompteRepository compteRepository;
	
	@Autowired
	private ClientRepository clientRepository;

	@Test
	void testCreateCompte() {
		Client client1= new Client("amina", 946342569, "monastir", 94361029);
		Courant courant= new Courant("A23456", new Date(), 0, client1, 500);
		Epargne epargne= new Epargne("C56478", new Date(), 0, client1, 0.36);
		
	    clientRepository.save(client1);
	    compteRepository.save(courant);
	    compteRepository.save(epargne);
	}
	
	@Test
	void testDeleteCompte(Compte com) {
		compteRepository.delete(com);
	}
}
