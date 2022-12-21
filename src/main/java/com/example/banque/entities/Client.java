package com.example.banque.entities;

import java.io.Serializable;
import java.util.Collection;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client implements Serializable {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id_Cl;
	private String name_Cl;
	private long cin;
	private String address_Cl;
	private long phone;
	
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
	private Collection<Compte> comptes;
	
	public Client( String name_Cl, long cin, String address, long phone) {
		this.name_Cl=name_Cl;
		this.cin=cin;
		this.address_Cl=address;
		this.phone=phone;
	}
	

}
