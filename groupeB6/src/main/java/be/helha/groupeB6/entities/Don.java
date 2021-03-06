package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Don implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double montant;

	
	
	public Don(double montant) {
		super();
		this.montant = montant;
	}
	
	public Don() {}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public double getMontant() {
		return montant;
	}



	public void setMontant(double montant) {
		this.montant = montant;
	}



	@Override
	public String toString() { 
		return  montant+" €";
	}
	
	
	
}
