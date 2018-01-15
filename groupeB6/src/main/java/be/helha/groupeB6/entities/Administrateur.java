package be.helha.groupeB6.entities;

import java.io.Serializable;
import java.util.Date;

public class Administrateur extends Utilisateur implements Serializable{

	public Administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrateur(int numero, int numTel, String nom, String prenom, String mail, String mdp,
			String nationalite, Date dateNaissance) {
		super(numero, numTel, nom, prenom, mail, mdp, nationalite, dateNaissance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
	
	
}
