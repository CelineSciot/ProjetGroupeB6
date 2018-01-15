package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Utilisateur;

@Remote
public interface IGestionUtilisateurEJBRemote {
	
	List<Utilisateur> SelectionnerUtilisateur();
	Utilisateur ajouterUtilisateur(Utilisateur u);
	Utilisateur supprimerUtilisateur(Utilisateur u);
	
	Evenement ajouterEvenement(Evenement e);
	Evenement supprimerEvenement(Evenement e);
	List<Utilisateur> afficherEvenenement();


}
