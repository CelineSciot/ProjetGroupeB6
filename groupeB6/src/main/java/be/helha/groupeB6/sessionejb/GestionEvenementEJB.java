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
		dao.supprimerEvenement(e);
		return null;
	}

	@Override
	public List<Evenement> afficherEvenenement() {
		return dao.afficherListeEvenement();
	}

	@Override
	public Evenement selectEvenement(Evenement e) {
		return dao.rechercheEvenement(e);
	}

	@Override
	public List<Evenement> afficherEvenementViaApprobation(boolean approuve) {
		return dao.afficherEvenementViaApprobation(approuve);
	}

	@Override
	public Evenement modifierEvenement(Evenement e) {
		dao.modifierEvenement(e);
		return null;
	}

	@Override
	public List<Evenement> afficherEvenementUser(Utilisateur u) {
		// TODO Auto-generated method stub
		return dao.afficherEvenementUser(u);
	}

}
