package banque.entites;


import javax.persistence.*;


@Entity
@Table(name="VIREMENT")

public class Virement extends AbstractOperation {

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;

	public Virement() {
		super();
	}

	/**
	 * @return the beneficiaire
	 */
	public String getBeneficiaire() {
		return beneficiaire;
	}

	/**
	 * @param beneficiaire the beneficiaire to set
	 */
	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
}
