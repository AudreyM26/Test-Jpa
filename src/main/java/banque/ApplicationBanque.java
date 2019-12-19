package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;


import banque.entites.*;

/***
 * - Créer les entités JPA suivantes et mettez en place les annotations relationnelles :
 * Banque
 * Compte
 * Operation
 * Client
 * 	Adresse (Embeddable)
 * - Les tables seront générées à partir des relations définies dans votre modèle métier
 * - Insérer en base de données des instances des différents objets en utilisant l’EntityManager
 * @author audrey
 *
 */


public class ApplicationBanque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("banque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Banque b = new Banque();
		b.setNom("Credit Agricole");
		em.persist(b);
		
		Banque b2 = new Banque();
		b2.setNom("CIC");
		em.persist(b2);
		
		Adresse a1 = new Adresse(17,"rue des étoiles",34500,"Béziers");
		Client client1 = new Client();
		client1.setNom("Lopez");
		client1.setPrenom("Lucas");
		client1.setDateNaissance(LocalDate.of(1982,11, 21));
		client1.setBanque(b);
		client1.setAdresse(a1);
		em.persist(client1);
		
		Client client2 = new Client();
		client2.setNom("Lopez");
		client2.setPrenom("Virginie");
		client2.setDateNaissance(LocalDate.of(1985,04, 16));
		client2.setBanque(b);
		client2.setAdresse(a1);
		em.persist(client2);
		
		Compte cpt1 = new Compte();
		cpt1.setNom("Compte courant");
		cpt1.setSolde(4200);
		cpt1.getClients().add(client1);
		em.persist(cpt1);
		
		Compte cpt2 = new Compte();
		cpt2.setNom("Compte joint");
		cpt2.setSolde(2000);
		cpt2.getClients().add(client1);
		cpt2.getClients().add(client2);
		em.persist(cpt2);
		
		
		Operation opCpt1 = new Operation();
		opCpt1.setCompte(cpt1);
		opCpt1.setDate(LocalDateTime.now());
		opCpt1.setMontant(500);
		opCpt1.setMotif("facture");
		em.persist(opCpt1);
		
		Virement opVir1 = new Virement();
		opVir1.setCompte(cpt1);
		opVir1.setDate(LocalDateTime.of(2019,10,15, 14, 52));
		opVir1.setMontant(-90);
		opVir1.setMotif("epargne");
		opVir1.setBeneficiaire("EDF");
		em.persist(opVir1);
		
		Operation opCpt2 = new Operation();
		opCpt2.setCompte(cpt2);
		opCpt2.setDate(LocalDateTime.now());
		opCpt2.setMontant(1200);
		opCpt2.setMotif("epargne");
		em.persist(opCpt2);
		
		//nouveau client avec plusieurs comptes : assurance vie et livret A
		Adresse a3 = new Adresse(21,"rue du quai port neuf",11100,"Narbonne");
		Client client3 = new Client();
		client3.setNom("Dupond");
		client3.setPrenom("Emile");
		client3.setDateNaissance(LocalDate.of(1975,05, 13));
		client3.setBanque(b2);
		client3.setAdresse(a3);
		em.persist(client3);
		
		LivretA livretA3 = new LivretA();
		livretA3.setNom("Livret A");
		livretA3.setSolde(2000);
		livretA3.getClients().add(client3);
		livretA3.setTaux(1.25);
		em.persist(livretA3);
		
		AssuranceVie assurVie3 = new AssuranceVie();
		assurVie3.setNom("Assurance Vie");
		assurVie3.setSolde(2000);
		assurVie3.getClients().add(client3);
		assurVie3.setTaux(1.25);
		assurVie3.setDateFin(LocalDate.of(2090, 05, 03));
		em.persist(assurVie3);
		
		Operation opLivretA3 = new Operation();
		opLivretA3.setCompte(livretA3);
		opLivretA3.setDate(LocalDateTime.of(2019,9,25, 15, 58));
		opLivretA3.setMontant(120);
		opLivretA3.setMotif("epargne");
		em.persist(opLivretA3);
		
		Virement opVir3 = new Virement();
		opVir3.setCompte(assurVie3);
		opVir3.setDate(LocalDateTime.of(2019,12,02, 9, 47));
		opVir3.setMontant(80);
		opVir3.setMotif("epargne");
		opVir3.setBeneficiaire(client3.getNom());
		em.persist(opVir3);
		
		transaction.commit();
		
		em.close();
	}

}
