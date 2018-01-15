package be.helha.groupeB6.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB6.entities.Utilisateur;


@Named
@RequestScoped
public class UtilisateurConstrol {
	
	private Utilisateur utilisateur = new Utilisateur();
	private int numero, numTel;
	private String nom,prenom,mail;
	private String mdp,nationalite;
	private Date dateNaissance;
	
	@EJB
	
	/*public List<Utilisateur> doUtil(){
		return gestionUtilisateur.selectAll();
	}
	
	public String ShowUser(Utilisateur u) {
		utilisateur= gestionUtilisateur.showUser(u);
		return"userinformation.xhtml";
	}
	
	public void AjouterUtilisateur() {
		gestionUtilisateur.addUtilisateur(int numero, int numTel, String nom, String prenom, String mail, String mdp, String nationalite, Date dateNaissance);
		this.numero=0;
		this.numTel=0;
		this.nom="";
		
	}*/

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	
	

}
