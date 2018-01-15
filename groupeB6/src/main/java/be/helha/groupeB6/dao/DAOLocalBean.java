package be.helha.groupeB6.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import be.helha.groupeB6.entities.Administrateur;
import be.helha.groupeB6.entities.Adresse;
import be.helha.groupeB6.entities.Utilisateur;
import be.helha.groupeB6.entities.Don;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Nouvelle;

@SuppressWarnings("unchecked")
@Stateless
@LocalBean
public class DAOLocalBean implements Serializable {
	
	@PersistenceContext(unitName="groupeb6JTA")
	private EntityManager em;

	
	
	public DAOLocalBean() {
		
	}
	
	//RECHERCHE
	public Utilisateur rechercherUtilisateur(Utilisateur u){
		String str= "SELECT u FROM Utilisateur u WHERE u.mail=:Nom";
		Query qNomUtil = em.createQuery(str);
		qNomUtil.setParameter("Nom", u.getMail());
		List<Utilisateur> result= (List<Utilisateur>)qNomUtil.getResultList();
		return result.get(0);
	
	}
	
	public Administrateur rechercherAdministrateur(Administrateur a){
		String str= "SELECT p FROM Administrateur p WHERE p.mail=:Nom";
		Query qNom = em.createQuery(str);
		qNom.setParameter("Nom", a.getMail());
		List<Administrateur> result= (List<Administrateur>)qNom.getResultList();
		return result.get(0);
	}
	
	public Utilisateur rechercherUtilisateurAdresse(Utilisateur u) {
		String strA= "SELECT p FROM Utilisateur p inner join Adresse a on p.adresse = a.id WHERE a.rue=:Rue";
		Query qAdr = em.createQuery(strA);
		qAdr.setParameter("Rue", u.getDomicile().getRue());
		List<Utilisateur> result= (List<Utilisateur>)qAdr.getResultList();
		return result.get(0);
	}
	
	public List<Don> rechercherDonParUtilisateur(Utilisateur u){
		String strA= "select p.dons FROM Abonne p where p.mail=:Nom";
		Query qDon = em.createQuery(strA);
		qDon.setParameter("Nom",u.getMail());
		List<Don> result= (List<Don>)qDon.getResultList();
		return result;
	}
	
	public List<Evenement> rechercheEvenementParUtilisateur(Utilisateur u){
		String strA= "select p.evenement FROM Utilusateur p where p.mail=:Nom";
		Query qEvenement = em.createQuery(strA);
		qEvenement.setParameter("Nom",u.getMail());
		List<Evenement> result= (List<Evenement>)qEvenement.getResultList();
		return result;
	}
	
	public Utilisateur rechercheListeUtilisateur(Utilisateur u) {
		List<Utilisateur> liste= afficherListeUtilisateur();
		for(int i=0;i< liste.size();i++) {
			if(liste.get(i).getMail().equals(u.getMail())) {
				return liste.get(i);
			}
		}
		return null;
	}
	
	
	//CRUD
	public void ajouterUtilisateur(Utilisateur u) {
		if(isExistingMail(u.getMail())) {
			System.out.println("ERROR");
			return;
		}
		em.persist(u);
	}
	
	public void ajouterAdmin(Administrateur a) {
		if(isExistingMail(a.getMail())) {
			System.out.println("ERROR");
			return;
		}
		em.persist(a);
	}
	
	public void ajouterDon(Don d) {
		em.persist(d);
	}
	
	public void ajouterEvenement(Evenement evenement) {
		em.persist(evenement);
	}
	
	public void ajouterNouvelle(Nouvelle n) {
		em.persist(n);
	}
	
	public void modifierUtilisateur(Utilisateur u1,Utilisateur u2){
		if(u2 == null) {return;}
		if(isExistingMail(u2.getMail())) {return ;}
		Utilisateur uu1 = rechercheListeUtilisateur(u1);
		if(uu1 == null) {return;}
		Utilisateur u=em.merge(uu1);
		u.setMail(u2.getMail());
		
	}
	
	public void supprimerNouvelle(Nouvelle n){
		String str="Delete FROM Nouvelle p WHERE p.id=:id";
		Query qSuppNouv = em.createQuery(str);
		qSuppNouv.setParameter("Nom",n.getId());
		qSuppNouv.executeUpdate();
	}
	
	public void supprimerUtilisateur(Utilisateur p){
		String str="Delete FROM Utilisateur p WHERE p.mail=:Nom";
		Query qSupp = em.createQuery(str);
		qSupp.setParameter("Nom",p.getMail());
		qSupp.executeUpdate();
	}
	
	
	//AFFICHER LISTE
	public List<Utilisateur> afficherListeUtilisateur(){
		String str="select u from Utilisateur u";
		Query qUser = em.createQuery(str);
		List<Utilisateur> result= (List<Utilisateur>)qUser.getResultList();

		return result;
	}
	
	public List<Utilisateur> afficherListeDon(){
		String str="select u from Utilisateur u";
		Query qUser = em.createQuery(str);
		List<Utilisateur> result= (List<Utilisateur>)qUser.getResultList();

		return result;
	}
	
	public List<Evenement> afficherListeEvenement(){
		String str="select evenements from Utilisateur u";
		Query qUser = em.createQuery(str);
		List<Evenement> result= (List<Evenement>)qUser.getResultList();

		return result;
	}
		
	public List<Administrateur> afficherListeAdministrateur(){
		String str="select u from Abonne u";
		Query qAdmin = em.createQuery(str);
		List<Administrateur> result= (List<Administrateur>)qAdmin.getResultList();

		return result;
	}
		
	//AUTRES
	private boolean isExistingMail(String mail) {
		List<Utilisateur> liste= afficherListeUtilisateur();
		for(int i=0;i< liste.size();i++) {
			if(liste.get(i).getMail().equals(mail)) {
				return true;
			}
		}
		return false;
	}
	
}


