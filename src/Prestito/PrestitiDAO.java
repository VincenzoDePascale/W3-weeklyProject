package Prestito;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import Pubblicazioni.*;
import Utente.Utente;
import Utente.UtentiDAO;

public class PrestitiDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-weeklyProject-java");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {

      }
	
	public static List<Prestito> findAllPrestiti() {
		Query q = em.createNamedQuery("prestiti.findAll");
		return q.getResultList();
	}
	
	public static void addPrestito(Prestito e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("prestito avviato!");
	}
	
	public static void dellPrestito(Prestito e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("prestito avviato!");
	}

}
