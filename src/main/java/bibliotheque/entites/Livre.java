package bibliotheque.entites;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="LIVRE")

public class Livre {

	@Id
	//@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	private String titre;
	private String auteur;
	
	@ManyToMany(mappedBy="livres")
	private Set<Emprunt> emprunts;
	
	public Livre() {
		super();
	}

	public String toString(){
		
		return this.getId()+" - Titre : "+this.getAuteur()+" - Auteur : "+this.getTitre();
		
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the auteur
	 */
	public String getAuteur() {
		return auteur;
	}

	/**
	 * @param auteur the auteur to set
	 */
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	/**
	 * @return the emprunts
	 */
	public Set<Emprunt> getEmprunts() {
		return emprunts;
	}

	/**
	 * @param emprunts the emprunts to set
	 */
	public void setEmprunts(Set<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}
}
