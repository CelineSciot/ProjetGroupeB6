package be.helha.groupeB6.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String rue;
	private String numero;
	private int codePostal;
	private String ville;
	
	
	public Adresse() {
		
	}
	
	public Adresse(String rue,String numero,int codePostal,String ville)
	{
		this.rue=rue;
		this.numero=numero;
		this.codePostal=codePostal;
		this.ville=ville;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return id + ", rue=" + rue + ", numero=" + numero + ", codePostal=" + codePostal + ", ville="
				+ ville;
	}
	

}
