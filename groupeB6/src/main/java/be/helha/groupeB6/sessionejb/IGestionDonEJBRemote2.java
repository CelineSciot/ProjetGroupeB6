package be.helha.groupeB6.sessionejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.groupeB6.entities.Don;
import be.helha.groupeB6.entities.Utilisateur;

@Remote
public interface IGestionDonEJBRemote2 {

	Don ajouterDon(Don d);
	List<Don> afficherDon();
	Don selectDon(Utilisateur u);

}
