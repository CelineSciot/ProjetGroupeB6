package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Nouvelle implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String image, titre, description;
	
	private Date dateN;

	public Nouvelle(String image, String titre, String description, Date dateN) {
		super();
		this.image = image;
		this.titre = titre;
		this.description = description;
		this.dateN = dateN;
	}
	
	public Nouvelle() {}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	@Override
	public String toString() {
		return "Nouvelle [id=" + id + ", image=" + image + ", titre=" + titre + ", description=" + description
				+ ", dateN=" + dateN + "]";
	}
	
	
}
