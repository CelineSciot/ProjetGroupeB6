package be.helha.groupeB6.controller;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.sessionejb.GestionEvenementEJB;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@RequestScoped
public class EvenementController {
	
	private Evenement evenement = new Evenement();
	private Date dateA;
	private String titre,description,typeCollecte, image;
	private double objectifFinancier;
	private boolean approuve;
	
	@EJB
	private GestionEvenementEJB gestionEvenement;
	
	public String doDetails(Evenement e)
	{
		evenement= gestionEvenement.selectEvenement(e);
		System.out.println(evenement);	
		return"DetailEvenement.xhtml";
	}
	
	public List<Evenement> doUtil(){
		return gestionEvenement.afficherEvenenement();
	}
	
	public void AjouterEvenement(Evenement e) {
		evenement = new Evenement(this.dateA,this.titre,this.description,this.typeCollecte,this.image,this.objectifFinancier) ;
		gestionEvenement.ajouterEvenement(evenement);
		this.dateA=null;
		this.titre="";
		this.description="";
		this.typeCollecte="";
		this.image="";
	}
	
	public void SupprimerEvenement(Evenement e) {
		gestionEvenement.supprimerEvenement(e);
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

	public GestionEvenementEJB getGestionUtilisateur() {
		return gestionEvenement;
	}

	public void setGestionUtilisateur(GestionEvenementEJB gestionEvenement) {
		this.gestionEvenement = gestionEvenement;
	}
	
	

}
