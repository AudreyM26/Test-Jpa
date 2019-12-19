package banque.entites;

import javax.persistence.*;

@Entity
@Table(name="LIVRETA")

public class LivretA extends Compte {

	@Column(name="TAUX")
	private double taux;

	public LivretA() {
		super();
	}

	/**
	 * @return the taux
	 */
	public double getTaux() {
		return taux;
	}

	/**
	 * @param taux the taux to set
	 */
	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
