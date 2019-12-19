package banque.entites;

import java.time.LocalDateTime;

import javax.persistence.*;


@Entity
@Table(name="OPERATION")

public class Operation extends AbstractOperation {


	public Operation() {
		super();
	}

	
	
}
