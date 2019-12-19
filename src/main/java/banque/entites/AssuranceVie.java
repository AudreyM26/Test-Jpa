package banque.entites;

import java.time.LocalDate;

import javax.persistence.*;


@Entity
@Table(name="ASSURANCEVIE")

public class AssuranceVie extends Compte {

	@Column(name="DATE_FIN")
	private LocalDate dateFin;
	
	@Column(name="TAUX")
	private double taux;

	
	public AssuranceVie() {
		super();
	}

	/**
	 * @return the dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
