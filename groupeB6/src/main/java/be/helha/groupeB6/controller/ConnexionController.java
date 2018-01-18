package be.helha.groupeB6.controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import be.helha.groupeB6.entities.GroupeUtilisateur;
import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@SessionScoped
public class ConnexionController implements Serializable{
	public static Utilisateur utilisateurConnecte;
	
	private String messageErreur;
	private Utilisateur utilisateur = new Utilisateur();
	private List<Utilisateur> listeUsers;
	@EJB
	private GestionUtilisateurEJB gestionUtilisateur;
	
	private String numTel;
	private String nom,prenom,j_username;
	private String j_password,nationalite;
	private	String  dateNaissance;
	private int compteur;
	private boolean role;
	
	private boolean connect;
	
	public void seConnecter() {
		listeUsers = gestionUtilisateur.SelectionnerUtilisateur();
		String mail = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		for(compteur = 0 ; compteur<listeUsers.size();compteur++) {
			if(listeUsers.get(compteur).getMail().equals(mail)) {
				utilisateurConnecte= listeUsers.get(compteur);
				
				connect = true;
				
			}
		}
	}
	
	public String doConnect() {
		return "login.xhtml?faces-redirect=true";
	}
	
	public String doAdmin() {
		return "indexAdmin.xhtml?faces-redirect=true";
	}

	
	public String logout() {
		HttpSession session = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.invalidate();
		connect = false;
		role = false;
		return "index.xhtml?faces-redirect=true;";
	}
	
	public static Utilisateur getUtilisateurConnecte() {
		return utilisateurConnecte;
	}

	public static void setUtilisateurConnecte(Utilisateur utilisateurConnecte) {
		ConnexionController.utilisateurConnecte = utilisateurConnecte;
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

	public GestionUtilisateurEJB getGestionUtilisateur() {
		return gestionUtilisateur;
	}

	public void setGestionUtilisateur(GestionUtilisateurEJB gestionUtilisateur) {
		this.gestionUtilisateur = gestionUtilisateur;
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

	public String getJ_username() {
		return j_username;
	}

	public void setJ_username(String j_username) {
		this.j_username = j_username;
	}

	public String getJ_password() {
		return j_password;
	}

	public void setJ_password(String j_password) {
		this.j_password = j_password;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean isConnect() {
		return connect;
	}

	public void setConnect(boolean connect) {
		this.connect = connect;
	}

	public boolean getRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}
	
	
	
	
}
