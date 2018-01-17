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
	
	public Evenement rechercheEvenement(Evenement e) {
		String str= "SELECT p FROM Evenement p WHERE p.titre=:Nom";
		Query qNom = em.createQuery(str);
		qNom.setParameter("Nom", e.getTitre());
		List<Evenement> result= (List<Evenement>)qNom.getResultList();
		return result.get(0);
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
		
		Utilisateur m=em.merge(evenement.getUtilisateur());
		
		evenement.setUtilisateur(m);
		em.persist(evenement);
	}
	
	public void ajouterNouvelle(Nouvelle n) {
		em.persist(n);
	}
	
	public void modifierUtilisateur(Utilisateur u1){
		
		Utilisateur uu1 = rechercheListeUtilisateur(u1);
		if(uu1 == null) {return;}
		Utilisateur u=em.merge(uu1);
		u.setDons(u1.getDons());
		
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
	
	public void supprimerEvenement(Evenement e){
		String str="Delete FROM Evenement p WHERE p.titre=:Nom";
		Query qSupp = em.createQuery(str);
		qSupp.setParameter("Nom",e.getTitre());
		qSupp.executeUpdate();
	}
	
	//AFFICHER LISTE
	public List<Utilisateur> afficherListeUtilisateur(){
		String str="select u from Utilisateur u";
		Query qUser = em.createQuery(str);
		List<Utilisateur> result= (List<Utilisateur>)qUser.getResultList();

		return result;
	}
	
	public List<Don> afficherListeDon(){
		String str="SELECT d FROM Don";
		Query qDon = em.createQuery(str);
		List<Don> result= (List<Don>)qDon.getResultList();
		return result;
	}
	
	public List<Evenement> afficherListeEvenement(){
		String str="select e from Evenement e";
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
	
	public List<Evenement> afficherEvenementViaApprobation(boolean approuve){
		String str="select e from Evenement e where e.approuve= :Approuve";
		Query qUser = em.createQuery(str);
		qUser.setParameter("Approuve",approuve);
		List<Evenement> result= (List<Evenement>)qUser.getResultList();

		return result;
	}
	
	public void modifierEvenement(Evenement e){
		Evenement evt = rechercheEvenement(e);
		if(evt == null) {return;}
		Evenement ee=em.merge(evt);
	
		ee.setApprouve(e.isApprouve());
		
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


