package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Utilisateur implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int numero, numTel;
	private String nom,prenom,mail;
	private String mdp,nationalite;
	private Date dateNaissance;
	
	@OneToOne(cascade=CascadeType.ALL)//DANGER => ALL
	private Adresse domicile;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Don> dons= new HashSet<Don>();
	

	public Utilisateur(int numero, int numTel, String nom, String prenom, String mail, String mdp, String nationalite, Date dateNaissance) {
		super();
		this.numero = numero;
		this.numTel = numTel;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.nationalite = nationalite;
		this.dateNaissance = dateNaissance;
	}
	
	public Utilisateur() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumTel() {
		return numTel;
	}

	public void setNumTel(int numTel) {
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

	
	
	public Adresse getDomicile() {
		return domicile;
	}

	public void setDomicile(Adresse domicile) {
		this.domicile = domicile;
	}

	
	public Set<Don> getDons() {
		return dons;
	}

	public void setDons(Set<Don> dons) {
		this.dons = dons;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", numero=" + numero + ", numTel=" + numTel + ", nom=" + nom + ", prenom="
				+ prenom + ", mail=" + mail + ", mdp=" + mdp + ", nationalite=" + nationalite + ", dateNaissance=" + dateNaissance + "]";
	}
	
	public void addDon(Don don) {
		dons.add(don);
	}

	
}
