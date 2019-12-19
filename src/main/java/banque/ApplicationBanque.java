package banque;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Persistence;

import banque.entites.*;



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
		Set<Client> clientsCpt1 = new HashSet <Client>();
		clientsCpt1.add(client1);
		cpt1.setClients(clientsCpt1);
		em.persist(cpt1);
		
		Compte cpt2 = new Compte();
		cpt2.setNom("Compte joint");
		cpt2.setSolde(2000);
		Set<Client> clientsCpt2 = new HashSet <Client>();
		clientsCpt2.add(client1);
		clientsCpt2.add(client2);
		cpt2.setClients(clientsCpt2);
		em.persist(cpt2);
		
		
		Operation opCpt1 = new Operation();
		opCpt1.setCompte(cpt1);
		opCpt1.setDate(LocalDateTime.now());
		opCpt1.setMontant(500);
		opCpt1.setMotif("facture");
		em.persist(opCpt1);
		
		
		Operation opCpt2 = new Operation();
		opCpt2.setCompte(cpt2);
		opCpt2.setDate(LocalDateTime.now());
		opCpt2.setMontant(1200);
		opCpt2.setMotif("epargne");
		em.persist(opCpt2);
		
		transaction.commit();
		
		em.close();
	}

}
