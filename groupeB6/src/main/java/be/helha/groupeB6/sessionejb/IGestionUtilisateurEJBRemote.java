package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB6.entities.GroupeUtilisateur;
import be.helha.groupeB6.entities.Utilisateur;

@Remote
public interface IGestionUtilisateurEJBRemote {
	
	List<Utilisateur> SelectionnerUtilisateur();
	Utilisateur ajouterUtilisateur(Utilisateur u);
	Utilisateur supprimerUtilisateur(Utilisateur u);
	Utilisateur modifierUser(Utilisateur u1);
	Utilisateur ajouterRole(Utilisateur u);
	List<GroupeUtilisateur> recupRole();
}
