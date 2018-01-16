package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.groupeB6.dao.DAOLocalBean;
import be.helha.groupeB6.entities.Don;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Utilisateur;

@Stateless
@LocalBean
public class GestionDonEJB implements IGestionDonEJBRemote2{

	@EJB
	private DAOLocalBean dao;
	
	@Override
	public Don ajouterDon(Don d) {
		dao.ajouterDon(d);
		return null;
	}

	@Override
	public List<Don> afficherDon() {
		// TODO Auto-generated method stub
		return dao.afficherListeDon();
	}

	@Override
	public Don selectDon(Utilisateur u) {
		return null;
	}

	

}
