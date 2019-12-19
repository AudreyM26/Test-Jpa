package banque.entites;

import javax.persistence.*;

@Embeddable
public class Adresse {

	@Column(name="NUMERO")
	private Integer numero;
	
	@Column(name="RUE")
	private String rue;
	
	@Column(name="CODE_POSTAL")
	private Integer codePostal;
	
	@Column(name="VILLE")
	private String ville;
	
	public Adresse() {
		super();
	}
	
	public Adresse(Integer numero, String rue, Integer codePostal, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
}
