package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB6.entities.Evenement;

@Remote
public interface IGestionEvenementEJBRemote {

	Evenement ajouterEvenement(Evenement e);
	Evenement supprimerEvenement(Evenement e);
	List<Evenement> afficherEvenenement();
	
	Evenement selectEvenement(Evenement e);
	List<Evenement>afficherEvenementViaApprobation(boolean approuve);
	Evenement modifierEvenement(Evenement e);
}
