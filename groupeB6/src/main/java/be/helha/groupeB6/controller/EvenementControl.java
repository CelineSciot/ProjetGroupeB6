package be.helha.groupeB6.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class EvenementControl {
	
	private Evenement evenement = new Evenement();
	private String dateA;
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
	public String doSupression(){
		return"SupressionEvenement.xhtml";
	}
	
	public void AjouterEvenement(Evenement e) {
		Date dateE=null;
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String image= "iVBORw0KGgoAAAANSUhEUgAAATUAAAAbCAYAAAAdzhj2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAASCSURBVHhe7ZkBdiIxCIb3XB7I83iaXsbDdPnZkCVIIrZaNf2/90ZnEiCQEGZG/3wSQshGsKgRQraCRY0QshUsaoSQrWBRI4RsBYsaIWQrWNQIIVvBokYI2YobitqHSIv4Ub4zTgfpl+Ms5+fT//MqX9F5BNGPj+O/uA/SvjVY38n8P2JtXmW9jXv4c5Q8Qa7gOC0MaU7JsaIiQ1Jk9qu0pD9kC98K3islaZnFZra45OtrrGy/Gu/k6wuCotjzZDaX0nCQfDquClZFhqy4vagd5Yh3IdxVdBHecVOsNvN3N/p39X+Sd/L11ZFJTG/+Bub6WsGqyJCM24vaOU62LaDfFP4c/TKMPZZLV96W6J9QKJuML6T6qmDti9cG/zrQX5ubbRRn6xtkzA98uz4bP7UJYkxBP3tt93Hg6CLQNR/bXFdihm/RhslA33wYxrW1bPIffhxTDrauzitsxvmAiLT31/hgcxpfkFvpxVjUFzngB8Y3zI+VP5UYB30P5MyXjGv9oCJDMmTFqrQFxaL7zYOk0oV1/f5cn+JMuJG1Xei7ZIL8kLBufP9b3pTE9mzDXsjObPs++cDGiU+wV/XDPA7jRh8LMft51Q0nMmYDOnoOW04Xcr1dxrBNeuFPMt7Q3vRtvGyN1admP9M18SE+LweinuuLscx8sfyd+uPx7YndrKjBvsmkwI7oLqnIkAyZ/SpucXshE3qBc/1R1icCyNpm+kqwNyRSlHUg6TCOHgXbir9ObGc2NZ4sARe+ZTrpXArVmL0cnibw1KXXImivQzqu+d8O3fCJzZk/lXm1caab28kv4wt2o173ox1pLLi2uZbzYSwj6JRyJyId6c0t4v2ZUZEhGbICVfyCYvHkvG8a4PuTxde7rwwnXZ2hbaXvrpcbwKEJb0khnf03joVtxV+HvpnNod0z8Q1kOt8tat0n6Vd5XMsYXr/sK3QTfwZ9Gw/nE5+ydVeCzWl80W7Qq867Pana9wUzu9JwLUbFy10DdjK/PRUZkiHZViUsqN3JeoL4/sniZwnV21b6sc9tEt00XrYB/4aNXLEN4liub2pTPu7y+mlJHPWC7BBzkEUfNpf5gmv8iTOs08xX1z7zpzyvDltjrzvIt7HlSxnikw//m5jmXdBLYzGZBnxFgfeFZ+ZPNUYvh/P4uq0kvmibyHcqMqSKZESVOPFygiTp+H53rkkow+jR5LO2mb4Srr3+9I8CacBmgMyQzNG2gCckyF28ukTZmU0A2daHA6bAYDugG8Z0oq3g4zTmIDtswuQaDOPK4ePWH8Fbe3fZjyEflXmdrXta1HA5iy/0xX/ZV7GYjIG18Osw9Uc+qjGavhbipmOHFtvMF7SJbqciQ6rIzL85mtS/bPF/POZHbLCVzWyT34H+ep/BIrIL71/UkKj9bvtL+OmYhyeaO7G0+YCihhvBKoZHxEiewhsWNcl0ezXQ4zfcXZ8Uc3+1u2OBKdm8Z1GzuZvYe0SM5KnIahJCyD6wqBFCtoJFjRCyFSxqhJCtYFEjhGwFixohZCtY1AghG/H5+Rfc87ZNZfAJ4QAAAABJRU5ErkJggg==";
		byte[] images= image.getBytes();	
			try {
				dateE=df.parse(this.dateA);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//evenement = new Evenement(dateE,this.titre,this.description,this.typeCollecte,this.objectifFinancier,false) ;
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
	
	
	

}
