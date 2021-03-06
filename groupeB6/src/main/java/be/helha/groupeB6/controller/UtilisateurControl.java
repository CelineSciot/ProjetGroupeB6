package be.helha.groupeB6.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;


@Named
@RequestScoped
public class UtilisateurControl {
	
	private Utilisateur utilisateur = new Utilisateur();
	private List<Utilisateur> listeUsers;

	
	private String numTel;
	private String nom,prenom,mail;
	private String mdp,nationalite;
	private	Date  dateNaissance;
	private String messageErreur;
	
	@EJB
	private GestionUtilisateurEJB gestionUtilisateur;
	
	public String doNext() {
		
		return "ListeEvenements.xhtml?faces-redirect=true";
	}
	
	public String doAjoutEvent() {
		
		return "ActionAjout.xhtml?faces-redirect=true";
	}
	public String doAjoutEventAdmin() {
		
		return "ActionAjoutAdmin.xhtml?faces-redirect=true";
	}
	
	public String doCreerCompte() {
		
		return "CreerCompte.xhtml?faces-redirect=true";
	}
	
	public List<Utilisateur> doUtil(){
		return gestionUtilisateur.SelectionnerUtilisateur();
	}
	
	public void ajouterUtilisateur() {

			utilisateur = new Utilisateur(this.nom, this.prenom, this.mail, this.numTel, this.mdp, this.nationalite,this.dateNaissance);
			gestionUtilisateur.ajouterUtilisateur(utilisateur);
			gestionUtilisateur.ajouterRole(utilisateur);
			System.out.println(this.nom);
			this.numTel="";
			this.nom="";
			this.prenom="";
			this.mail="";
			this.mdp="";
			this.nationalite="";
			this.dateNaissance= null;	
		}
	
	public void supprimerUtilisateur(Utilisateur u) {
		gestionUtilisateur.supprimerUtilisateur(u);
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
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

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	

}
