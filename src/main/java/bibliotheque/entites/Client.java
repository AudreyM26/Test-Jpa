package bibliotheque.entites;

import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="CLIENT")

public class Client {

	@Id
	//@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="NOM")
	private String nom;
	@Column(name="PRENOM")
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunts;
	
	public Client() {
		super();
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
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
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
