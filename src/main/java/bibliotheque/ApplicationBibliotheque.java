package bibliotheque;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bibliotheque.entites.*;

public class ApplicationBibliotheque {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("bibliotheque");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		
		Livre livre1 = em.find(Livre.class,1);
		
		if (livre1 != null){
			System.out.println(livre1.getId()+" "+livre1.getTitre());
		}
		
		TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE TITRE=:titre",Livre.class);
		query.setParameter("titre","Germinal");
		
		
		List<Livre> results = query.getResultList();
		
		for(Livre livres : results){
			System.out.println(livres.getId()+" "+livres.getTitre()+" "+livres.getAuteur());
		}
		
		
		TypedQuery<Emprunt> empruntQuery = em.createQuery("SELECT e FROM Emprunt e WHERE ID=:id",Emprunt.class);
		empruntQuery.setParameter("id","1");
		
		
		List<Emprunt> emprunts = empruntQuery.getResultList();
		
		for(Emprunt e : emprunts){
			System.out.println(e.getLivres());
		}
		
		TypedQuery<Emprunt> empruntClientQuery = em.createQuery("SELECT e FROM Emprunt e WHERE ID_CLIENT=:id_client",Emprunt.class);
		empruntClientQuery.setParameter("id_client","3");
		
		
		List<Emprunt> empruntsClient = empruntClientQuery.getResultList();
		
		for(Emprunt e : empruntsClient){
			System.out.println(e.getLivres()+" "+e);
		}
		
		em.close();
		
	}

}
