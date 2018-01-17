package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Evenement implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Utilisateur utilisateur;
	
	private Date dateA;
	private String titre,description,typeCollecte,lieu;
	
	private double objectifFinancier;
	private boolean approuve;
	
	@Lob
	private byte[] images;


	
	public Evenement(Date dateA, String titre, String description, String typeCollecte,
			double objectifFinancier, boolean approuve, byte[] images,String lieu) {
		super();
		this.dateA = dateA;
		this.titre = titre;
		this.description = description;
		this.typeCollecte = typeCollecte;
		this.objectifFinancier = objectifFinancier;
		this.approuve = approuve;
		this.images = images;
		this.lieu=lieu;
	}

	public Evenement() {}

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



	public double getObjectifFinancier() {
		return objectifFinancier;
	}

	public void setObjectifFinancier(double objectifFinancier) {
		this.objectifFinancier = objectifFinancier;
	}

	public boolean isApprouve() {
		return approuve;
	}

	public void setApprouve(boolean approuve) {
		this.approuve = approuve;
	}

	public String getImages() {
		byte [] tmp = Base64.getEncoder().encode(images);
		return new String (tmp);
	}

	public void setImages(byte[] images) {
		this.images = images;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
	
	
	
}
