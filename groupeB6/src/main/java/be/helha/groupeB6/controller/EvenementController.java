package be.helha.groupeB6.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@RequestScoped
public class EvenementController {
	
	private Evenement evenement = new Evenement();
	private Date dateA;
	private String titre,description,typeCollecte, image;
	
	@EJB
	private GestionUtilisateurEJB gestionUtilisateur;
	
	public List<Utilisateur> doUtil(){
		return gestionUtilisateur.afficherEvenenement();
	}
	
	public void AjouterEvenement(Evenement e) {
		gestionUtilisateur.ajouterEvenement(e);
		this.dateA=null;
		this.titre="";
		this.description="";
		this.typeCollecte="";
		this.image="";
	}
	
	public void SupprimerEvenement(Evenement e) {
		gestionUtilisateur.supprimerEvenement(e);
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTypeCollecte() {
		return typeCollecte;
	}

	public void setTypeCollecte(String typeCollecte) {
		this.typeCollecte = typeCollecte;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public GestionUtilisateurEJB getGestionUtilisateur() {
		return gestionUtilisateur;
	}

	public void setGestionUtilisateur(GestionUtilisateurEJB gestionUtilisateur) {
		this.gestionUtilisateur = gestionUtilisateur;
	}
	
	

}