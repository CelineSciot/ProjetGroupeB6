package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Action implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private Date dateA;
	private String titre,description,typeCollecte, image;
	
	private double objectifFinancier;

	public Action(Date dateA, String titre, String description, String typeCollecte, String image,
			double objectifFinancier) {
		super();
		this.dateA = dateA;
		this.titre = titre;
		this.description = description;
		this.typeCollecte = typeCollecte;
		this.image = image;
		this.objectifFinancier = objectifFinancier;
	}
	
	public Action() {}

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

	public double getObjectifFinancier() {
		return objectifFinancier;
	}

	public void setObjectifFinancier(double objectifFinancier) {
		this.objectifFinancier = objectifFinancier;
	}

	@Override
	public String toString() {
		return "Action [id=" + id + ", dateA=" + dateA + ", titre=" + titre + ", description=" + description
				+ ", typeCollecte=" + typeCollecte + ", image=" + image + ", objectifFinancier=" + objectifFinancier
				+ "]";
	}
	
	
	
}
