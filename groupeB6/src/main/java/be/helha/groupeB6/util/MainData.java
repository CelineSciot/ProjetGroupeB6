package be.helha.groupeB6.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.groupeB6.entities.Administrateur;
import be.helha.groupeB6.entities.Adresse;
import be.helha.groupeB6.entities.Evenement;
import be.helha.groupeB6.entities.GroupeUtilisateur;
import be.helha.groupeB6.entities.Utilisateur;

public class MainData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Utilisateur user= new Utilisateur("user", "user", "user", "0498/012334", "helha", "Belge", null);
		
		
		Adresse adresse1 = new Adresse("R1", "N1", 1000, "V1");
		Adresse adresse2 = new Adresse("R2","N2",2000,"V2");
		
		user.setDomicile(adresse1);
		
		
		String evtD1 ="Une marche nocturne sera organisée le 05 décembre 2018. Prix de participation:  5€ /personne";
		String image= "iVBORw0KGgoAAAANSUhEUgAAATUAAAAbCAYAAAAdzhj2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAASCSURBVHhe7ZkBdiIxCIb3XB7I83iaXsbDdPnZkCVIIrZaNf2/90ZnEiCQEGZG/3wSQshGsKgRQraCRY0QshUsaoSQrWBRI4RsBYsaIWQrWNQIIVvBokYI2YobitqHSIv4Ub4zTgfpl+Ms5+fT//MqX9F5BNGPj+O/uA/SvjVY38n8P2JtXmW9jXv4c5Q8Qa7gOC0MaU7JsaIiQ1Jk9qu0pD9kC98K3islaZnFZra45OtrrGy/Gu/k6wuCotjzZDaX0nCQfDquClZFhqy4vagd5Yh3IdxVdBHecVOsNvN3N/p39X+Sd/L11ZFJTG/+Bub6WsGqyJCM24vaOU62LaDfFP4c/TKMPZZLV96W6J9QKJuML6T6qmDti9cG/zrQX5ubbRRn6xtkzA98uz4bP7UJYkxBP3tt93Hg6CLQNR/bXFdihm/RhslA33wYxrW1bPIffhxTDrauzitsxvmAiLT31/hgcxpfkFvpxVjUFzngB8Y3zI+VP5UYB30P5MyXjGv9oCJDMmTFqrQFxaL7zYOk0oV1/f5cn+JMuJG1Xei7ZIL8kLBufP9b3pTE9mzDXsjObPs++cDGiU+wV/XDPA7jRh8LMft51Q0nMmYDOnoOW04Xcr1dxrBNeuFPMt7Q3vRtvGyN1admP9M18SE+LweinuuLscx8sfyd+uPx7YndrKjBvsmkwI7oLqnIkAyZ/SpucXshE3qBc/1R1icCyNpm+kqwNyRSlHUg6TCOHgXbir9ObGc2NZ4sARe+ZTrpXArVmL0cnibw1KXXImivQzqu+d8O3fCJzZk/lXm1caab28kv4wt2o173ox1pLLi2uZbzYSwj6JRyJyId6c0t4v2ZUZEhGbICVfyCYvHkvG8a4PuTxde7rwwnXZ2hbaXvrpcbwKEJb0khnf03joVtxV+HvpnNod0z8Q1kOt8tat0n6Vd5XMsYXr/sK3QTfwZ9Gw/nE5+ydVeCzWl80W7Qq867Pana9wUzu9JwLUbFy10DdjK/PRUZkiHZViUsqN3JeoL4/sniZwnV21b6sc9tEt00XrYB/4aNXLEN4liub2pTPu7y+mlJHPWC7BBzkEUfNpf5gmv8iTOs08xX1z7zpzyvDltjrzvIt7HlSxnikw//m5jmXdBLYzGZBnxFgfeFZ+ZPNUYvh/P4uq0kvmibyHcqMqSKZESVOPFygiTp+H53rkkow+jR5LO2mb4Srr3+9I8CacBmgMyQzNG2gCckyF28ukTZmU0A2daHA6bAYDugG8Z0oq3g4zTmIDtswuQaDOPK4ePWH8Fbe3fZjyEflXmdrXta1HA5iy/0xX/ZV7GYjIG18Osw9Uc+qjGavhbipmOHFtvMF7SJbqciQ6rIzL85mtS/bPF/POZHbLCVzWyT34H+ep/BIrIL71/UkKj9bvtL+OmYhyeaO7G0+YCihhvBKoZHxEiewhsWNcl0ezXQ4zfcXZ8Uc3+1u2OBKdm8Z1GzuZvYe0SM5KnIahJCyD6wqBFCtoJFjRCyFSxqhJCtYFEjhGwFixohZCtY1AghG/H5+Rfc87ZNZfAJ4QAAAABJRU5ErkJggg==";
		byte[] images= image.getBytes();	
		
		String dateA = "2018-01-18 00:00:00.0";
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(dateA);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroupeUtilisateur gu = new GroupeUtilisateur("test", "test");
		
		Evenement evt1 = new Evenement(date, "Marche nocturne", evtD1, "individuel", 1700,true, images,"Paris");
		evt1.setUtilisateur(user);
		String evtD2 ="Un marché aux jouets sera organisé où les bénéfices seront reversés à médecin sans frontières.";
		
		
		String evtD3 ="Marathon de Durbuy dans une ambiance assurée. Participation: 5€ /couple";
		Evenement evt3 = new Evenement(date, "Marathon de Durbuy", evtD3, "collectif", 15220,false, images,"Soignies");
		evt3.setUtilisateur(user);
		
		EntityManagerFactory emf =Persistence.createEntityManagerFactory("dbb6");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx= em.getTransaction();

		tx.begin();
		
		em.persist(user);
		em.persist(evt1);
		em.persist(evt3);
		em.persist(gu);
		System.out.println("ok");
		
		
		tx.commit();
		em.clear();
		em.close();
		emf.close();
		
	}

}
