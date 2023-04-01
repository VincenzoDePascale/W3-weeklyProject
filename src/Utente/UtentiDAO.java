package Utente;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

import Pubblicazioni.Pubblicazione;

public class UtentiDAO {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-weeklyProject-java");
	static EntityManager em = emf.createEntityManager();
	
	public static void main(String[] args) {

      try {
    	  Utente U1 = new Utente();
    	  U1.setNome("gennaro");
    	  U1.setCognome("savastano");
    	  U1.setNascita(LocalDate.of(1962, 5, 7));
    	  U1.setTessera(1001l);
    	  //addToUtente(U1);
    	  
    	  Utente U2 = new Utente();
    	  U2.setNome("maria");
    	  U2.setCognome("silvani");
    	  U2.setNascita(LocalDate.of(1999, 9, 1));
    	  U2.setTessera(1002l);
    	  //addToUtente(U2);
    	  
    	  //List<Utente> listaUtenti = findAllUtenti();
    	  //findAllUtenti();
		  //System.out.println(lista);
	
       }catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
      

	}
	
	public static List<Utente> findAllUtenti() {
		Query q = em.createNamedQuery("utenti.findAll");
		return q.getResultList();
	}
	
	public static void addToUtente(Utente e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("utente creato!");
	}
	
	public static void dellUtente(Utente u) {
		em.getTransaction().begin();
		em.remove(u);
		em.getTransaction().commit();
		System.out.println("utente eliminato!");
	}

	public static Utente searchById(Long id) {
		em.getTransaction().begin();
		Utente a = em.find(Utente.class, id);
		em.getTransaction().commit();
		if(a != null) {
			System.out.println(a.toString());
		} else {
			System.out.println("nessun utente trovato con id:" + id);
		}
		return a;
		
	}
}
