package compta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestJpa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("compta");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		Fournisseur f = em.find(Fournisseur.class,1);
		if (f != null){
			System.out.println(f.getId()+" "+f.getNom());
		}
		
		Fournisseur f2 = em.find(Fournisseur.class,2);
		if (f2 != null){
			System.out.println(f2.getId()+" "+f2.getNom());
		}
		
		
		
		
		
		Fournisseur f4 = em.find(Fournisseur.class,4);
		
		if (f4 == null){
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			
			f4 = new Fournisseur();
			f4.setId(4);
			f4.setNom("Maison de la peinture");
			em.persist(f4);
			
			et.commit();
			
			
		}

		em.close();
		
	}
}
