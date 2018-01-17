package be.helha.groupeB6.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.UploadPage;
import be.helha.groupeB6.sessionejb.GestionEvenementEJB;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@RequestScoped
public class EvenementControl {
	
	private Evenement evenement = new Evenement();
	private String dateA;
	private String titre,description,typeCollecte, image;
	private double objectifFinancier;
	private boolean approuve;
	
	private UploadPage up = new UploadPage();
	
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
	public String doSupression(){
		return"SupressionEvenement.xhtml";
	}
	
	public void ajouterEvenement() {
		byte[] images= up.uploadFile();

		Date dateE=null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			
			try {
				dateE=df.parse(this.dateA);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		evenement = new Evenement(dateE,this.titre,this.description,this.typeCollecte,this.objectifFinancier,false,images,UtilisateurControl.utilisateurConnecte.getId()) ;
		gestionEvenement.ajouterEvenement(evenement);
		this.dateA=null;
		this.titre="";
		this.description="";
		this.typeCollecte="";
		this.image="";
		this.objectifFinancier=0.0;
	}
	
	public void SupprimerEvenement(Evenement e) {
		gestionEvenement.supprimerEvenement(e);
	}
	
	public void afficherEvenementViaApprobation(boolean approuve,Evenement e) {
		gestionEvenement.afficherEvenementViaApprobation(approuve);
		gestionEvenement.modifierEvenement(e);
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
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

	public double getObjectifFinancier() {
		return objectifFinancier;
	}

	public void setObjectifFinancier(double objectifFinancier) {
		this.objectifFinancier = objectifFinancier;
	}

	public String getDateA() {
		return dateA;
	}

	public void setDateA(String dateA) {
		this.dateA = dateA;
	}

	public UploadPage getUp() {
		return up;
	}

	public void setUp(UploadPage up) {
		this.up = up;
	}
	
	
	

}
