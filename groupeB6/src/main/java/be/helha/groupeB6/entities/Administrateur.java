package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur implements Serializable{

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur( String nom, String prenom, String mail,String numTel, String mdp,
			String nationalite, Date dateNaissance) {
		super( nom, prenom, mail,  numTel,mdp, nationalite, dateNaissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	
	
}
