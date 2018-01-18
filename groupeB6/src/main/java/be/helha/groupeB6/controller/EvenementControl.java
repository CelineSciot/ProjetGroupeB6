package be.helha.groupeB6.controller;

import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.UploadPage;
import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.sessionejb.GestionEvenementEJB;
import be.helha.groupeB6.sessionejb.GestionUtilisateurEJB;

@Named
@SessionScoped
public class EvenementControl implements Serializable{
	
	private Evenement evenement = new Evenement();
	private String lieu;
	private String titre,description,typeCollecte, image;
	private double objectifFinancier;
	private boolean approuve;
	private Date dateA;
	
	private UploadPage up = new UploadPage();
	private List<Evenement> listeVoulue;
	
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
	public String doGestion() {
		return "GestionEvenement.xhtml";
	}
	
	public void ajouterEvenement() {
		byte[] images= up.uploadFile();
			if(!UtilisateurControl.utilisateurConnecte.getNom().equals("0"))
			{
				evenement = new Evenement(this.dateA,this.titre,this.description,this.typeCollecte,this.objectifFinancier,false,images,this.lieu) ;
				evenement.setUtilisateur(UtilisateurControl.utilisateurConnecte);
				gestionEvenement.ajouterEvenement(evenement);
			}
		
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
	
	public void afficherEvenementViaApprobation(boolean approuve) {

		listeVoulue =gestionEvenement.afficherEvenementViaApprobation(approuve);		
	}
	
	public void supprimerEvenementAdmin(Evenement e)
	{
		gestionEvenement.supprimerEvenement(e);
		afficherEvenementViaApprobation(false);
	}
	public void approuveEvenement(Evenement evt) {
		System.out.println("Passe dans approuveEvnt");
		evt.setApprouve(true);
		gestionEvenement.modifierEvenement(evt);
		afficherEvenementViaApprobation(false);
	}
	
	public List<Evenement> afficherEvenementUser() {
		
		return gestionEvenement.afficherEvenementUser(UtilisateurControl.utilisateurConnecte);
		
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

	public Date getDateA() {
		return dateA;
	}

	public void setDateA(Date dateA) {
		this.dateA = dateA;
	}

	public UploadPage getUp() {
		return up;
	}

	public void setUp(UploadPage up) {
		this.up = up;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public List<Evenement> getListeVoulue() {
		return listeVoulue;
	}

	public void setListeVoulue(List<Evenement> listeVoulue) {
		this.listeVoulue = listeVoulue;
	}
	
	
	

}
