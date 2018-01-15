package be.helha.groupeB6.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.groupeB6.entities.Administrateur;
import be.helha.groupeB6.entities.Adresse;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.Utilisateur;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur user= new Utilisateur("user", "user", "user", "0498/012334", "helha", "Belge", null);
		Administrateur admin= new Administrateur("admin", "admin","admin", "0495/015015", "helha", "Belge", null );
		
		Adresse adresse1 = new Adresse("R1", "N1", 1000, "V1");
		Adresse adresse2 = new Adresse("R2","N2",2000,"V2");
		
		user.setDomicile(adresse1);
		admin.setDomicile(adresse2);
		
		String evtD1 ="Une marche nocturne sera organisée le 05 décembre 2018. Prix de participation:  5€ /personne";
		Evenement evt1 = new Evenement(null, "Marche nocturne", evtD1, "individuel", "", 1700);
		
		String evtD2 ="Un marché aux jouets sera organisé où les bénéfices seront reversés à médecin sans frontières.";
		Evenement evt2 = new Evenement(null, "Marché aux jouets", evtD2, "collectif", "", 500);
		
		String evtD3 ="Marathon de Durbuy dans une ambiance assurée. Participation: 5€ /couple";
		Evenement evt3 = new Evenement(null, "Marathon de Durbuy", evtD3, "collectif", "", 2500);
		
		user.addEvenement(evt1);
		user.addEvenement(evt2);
		user.addEvenement(evt3);
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dbb6");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();

		tx.begin();
		
		em.persist(user);
		em.persist(admin);
		
		System.out.println("ok");
		
		
		tx.commit();
		em.clear();
		em.close();
		emf.close();
		
	}

}
