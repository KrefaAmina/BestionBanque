package com.example.banque.entities;



import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courant extends Compte implements Serializable {
	
	
	private double montantDecouvretAutorise ;
	
	public Courant(String num_Com, Date dateCreation, double solde, Client cleint, double decouvert) {
		super(num_Com, dateCreation, solde, cleint);
		this.montantDecouvretAutorise = decouvert;
	}
	
	

}
