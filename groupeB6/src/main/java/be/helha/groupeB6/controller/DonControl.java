package be.helha.groupeB6.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB6.entities.Don;
import be.helha.groupeB6.sessionejb.GestionDonEJB;
import be.helha.groupeB6.sessionejb.GestionEvenementEJB;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@RequestScoped
public class DonControl {
	
	private Don don = new Don();
	
	private Set<Don> dons = new HashSet();
	private double montant;
	
	
	@EJB
	private GestionDonEJB gestionDon;
	
	@EJB
	private GestionUtilisateurEJB gestionUser;
	
	public void doDon()
	{
		dons = UtilisateurControl.utilisateurConnecte.getDons();
		System.out.println(dons);	
		
	}
	
	
	public void ajouterDon() {
		don = new Don(this.montant);
		//gestionDon.ajouterDon(don);
		UtilisateurControl.utilisateurConnecte.addDon(don);
		gestionUser.modifierUser(UtilisateurControl.utilisateurConnecte);
		this.montant=0;
	}


	public Don getDon() {
		return don;
	}


	public void setDon(Don don) {
		this.don = don;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public Set<Don> getDons() {
		return dons;
	}


	public void setDons(Set<Don> dons) {
		this.dons = dons;
	}
	

	
	

}
