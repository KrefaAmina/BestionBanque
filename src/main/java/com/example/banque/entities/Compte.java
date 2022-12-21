package com.example.banque.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Compte implements Serializable {

	@Id 
	private String num_Com;
	private Date date_Open;
	private double solde;
	
	
	@ManyToOne
	@JoinColumn(name="id_Cl")
	private Client client;
	
}
