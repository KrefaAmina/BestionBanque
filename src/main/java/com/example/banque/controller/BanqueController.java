package com.example.banque.controller;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.banque.entities.Client;
import com.example.banque.entities.Compte;
import com.example.banque.entities.Courant;
import com.example.banque.entities.Epargne;
import com.example.banque.repository.ClientRepository;
import com.example.banque.repository.CompteRepository;
import com.example.banque.service.BanqueService;

@RestController
public class BanqueController {
	

	@Autowired
	private BanqueService banqueService;
	
	@Autowired 
	ClientRepository clientRepository;
	
	@Autowired
	CompteRepository compteRepository;
	
	
	@RequestMapping(value="/consulterCompte")
	public String consulter( String num_Comp) {
			Compte compte = banqueService.consulterCompte(num_Comp);
		return "comptes";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createNewAccount(String numCom, String name, Long phone, Long cin, String address, String typeCompte,
			double decouvert, double taux, String solde) {
		
		double _solde = Double.parseDouble(solde);
		
		Client client=clientRepository.save(new Client(name,cin,address,phone));
		System.out.println("===::"+typeCompte+"===::===");
		if(typeCompte.contentEquals("compteCourant")) {
			double _decouvert = decouvert;
			compteRepository.save(new Courant(numCom,new Date(),_solde,client,_decouvert));
		}
		
		if(typeCompte.contentEquals("compteEpargne")) {
			double _taux = taux;
			compteRepository.save(new Epargne(numCom,new Date(),_solde,client,_taux));
		}
		
		return "Compte ajouté ";
	}
	
	@DeleteMapping("/deleteCompte/{num_Comp}")
	public void delete(@PathVariable String num_Comp) {
		banqueService.delete(num_Comp);
	}
	
}
