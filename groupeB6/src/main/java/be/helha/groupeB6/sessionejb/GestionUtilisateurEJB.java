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
public class GestionUtilisateurEJB implements IGestionUtilisateurEJBRemote {

	@EJB
	private DAOLocalBean dao;
	
	@Override
	public List<Utilisateur> SelectionnerUtilisateur() {
		// TODO Auto-generated method stub
		return dao.afficherListeUtilisateur();
	}

	@Override
	public Utilisateur ajouterUtilisateur(Utilisateur u) {
		dao.ajouterUtilisateur(u);
		return null;
	}

	@Override
	public Utilisateur supprimerUtilisateur(Utilisateur u) {
		dao.supprimerUtilisateur(u);
		return null;
	}

	@Override
	public Utilisateur modifierUser(Utilisateur u1) {
		dao.modifierUtilisateur(u1);
		return null;
	}
	
	



}
