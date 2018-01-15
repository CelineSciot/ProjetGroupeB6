package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB6.dao.DAOLocalBean;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Utilisateur;

@Stateless
@LocalBean
public class GestionEvenementEJB implements IGestionEvenementEJBRemote{

	@EJB
	private DAOLocalBean dao;
	
	@Override
	public Evenement ajouterEvenement(Evenement e) {
		dao.ajouterEvenement(e);
		return null;
	}

	@Override
	public Evenement supprimerEvenement(Evenement e) {
		dao.afficherListeEvenement();
		return null;
	}

	@Override
	public List<Evenement> afficherEvenenement() {
		return dao.afficherListeEvenement();
	}

}
