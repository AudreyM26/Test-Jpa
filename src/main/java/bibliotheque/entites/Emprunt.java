package bibliotheque.entites;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import java.util.Iterator;


@Entity
@Table(name="EMPRUNT")

public class Emprunt {

	@Id
	@Column(name="ID")
	//@GeneratedValue (strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name="COMPO",
			joinColumns=@JoinColumn(name="ID_EMP",referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_LIV",referencedColumnName="ID")
	)
	private Set<Livre> livres;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client client;
	
	@Column(name="DATE_DEBUT")
	private LocalDateTime dateBegin;
	@Column(name="DATE_FIN")
	private LocalDateTime dateEnd;
	@Column(name="DELAI")
	private int delai;
	
	public Emprunt() {
		super();
	}
	
	public String toString(){
		
		String texte = "date début : "+this.getDateBegin();
		if(this.getDateEnd() != null){
			texte = texte+"- date fin : "+this.getDateEnd();
		}
	
		texte = texte+" - délai :"+this.getDelai()+" jours \n";
		
		Iterator<Livre> it = this.getLivres().iterator();
		while(it.hasNext()){
	         texte = texte+" "+it.next().toString()+"\n";
	    }
		
		return texte;
		
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
	 * @return the dateBegin
	 */
	public LocalDateTime getDateBegin() {
		return dateBegin;
	}

	/**
	 * @param dateBegin the dateBegin to set
	 */
	public void setDateBegin(LocalDateTime dateBegin) {
		this.dateBegin = dateBegin;
	}

	/**
	 * @return the dateEnd
	 */
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}

	/**
	 * @param dateEnd the dateEnd to set
	 */
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}

	/**
	 * @return the delai
	 */
	public int getDelai() {
		return delai;
	}

	/**
	 * @param delai the delai to set
	 */
	public void setDelai(int delai) {
		this.delai = delai;
	}


	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

	/**
	 * @return the livres
	 */
	public Set<Livre> getLivres() {
		return livres;
	}

	/**
	 * @param livres the livres to set
	 */
	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
}
