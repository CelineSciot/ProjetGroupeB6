package be.helha.groupeB6.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;


@Named
@RequestScoped
public class UtilisateurConstrol {
	
	private Utilisateur utilisateur = new Utilisateur();
	private int numero, numTel;
	private String nom,prenom,mail;
	private String mdp,nationalite;
	private Date dateNaissance;
	
	@EJB
	private GestionUtilisateurEJB gestionUtilisateur;
	
	public String doNext() {
		
		return "ListeEvenements.xhtml?faces-redirect=true";
	}
	
	public String doAjoutEvent() {
		
		return "ActionAjout.xhtml?faces-redirect=true";
	}
	
	public List<Utilisateur> doUtil(){
		return gestionUtilisateur.SelectionnerUtilisateur();
	}
	
	public void AjouterUtilisateur(Utilisateur u) {
		gestionUtilisateur.ajouterUtilisateur(u);
		this.numero=0;
		this.numTel=0;
		this.nom="";
		this.prenom="";
		this.mail="";
		this.mdp="";
		this.nationalite="";
		this.dateNaissance= null;	
	}
	
	public void SupprimerUtilisateur(Utilisateur u) {
		gestionUtilisateur.supprimerUtilisateur(u);
	}
	

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
