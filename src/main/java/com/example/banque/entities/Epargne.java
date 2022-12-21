package com.example.banque.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Epargne extends Compte implements Serializable {
	
	private double TauxInterets;
	
	public Epargne(String num_Comp, Date dateCreation, double solde, Client cleint, double taux) {
		super(num_Comp, dateCreation, solde, cleint);
		this.TauxInterets = taux;
	}

}
