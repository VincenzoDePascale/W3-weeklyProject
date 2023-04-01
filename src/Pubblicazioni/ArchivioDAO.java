package Pubblicazioni;

import java.util.List;
import java.util.Scanner;

import javax.persistence.*;

public class ArchivioDAO {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-weeklyProject-java");
	static EntityManager em = emf.createEntityManager();
	static Scanner input = new Scanner(System.in);
		
	public static void main(String[] args) {
		
		
		try{
			
			Libro L1 = new Libro();
			L1.setIsbn(91l);
			L1.setTitolo("titoloLibro1");
			L1.setAutore("autorelibro1");
			L1.setGenere("generelibro1");
			L1.setPagine(111);
			L1.setAnnopubblicazione(2022);
			//addToCatalogue(L1);
			
			Rivista R1 = new Rivista();
			R1.setIsbn(92l);
			R1.setTitolo("titoloRivista1");
			R1.setPagine(11);
			R1.setAnnopubblicazione(2022);
			R1.setPeriodicita(Periodicita.MENSILE);
			//addToCatalogue(R1);
			
			
			List<Pubblicazione> lista = findAllCatalogo();
			//findAll();
			//System.out.println(lista);
			
			//searchById(2l);ok
			//Pubblicazione pLetta = serchByIsbn(92l);
			// System.out.println("pLetta" + pLetta.toString());
			//searchByYearDate(2022);ok
			//searchByAutore("autorelibro1");
			//searchByTitolo("tit");ok
			
						
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}
	
	public static List<Pubblicazione> findAllCatalogo() {
		Query q = em.createNamedQuery("pubblicazioni.findAll");
		return q.getResultList();
	}
	
	public static void addToCatalogue(Object e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		System.out.println("oggetto aggiunto all'archivio!");
	}
	
	public static Pubblicazione searchById(Long id) {
		em.getTransaction().begin();
		Pubblicazione a = em.find(Pubblicazione.class, id);
		em.getTransaction().commit();
		if(a != null) {
			System.out.println(a.toString());
		} else {
			System.out.println("nessuna pubblicazione trovata con in:" + id);
		}
		return a;
		
	}
	
	public static Pubblicazione serchByIsbn(Long isbn) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.isbn = :isbn", Pubblicazione.class);
	    query.setParameter("isbn", isbn);
	    Pubblicazione resultp = query.getSingleResult();
	    
	    em.getTransaction().commit();
	    if (resultp != null) {
	    	System.out.println(resultp.toString());
	    	//dellPubblicazione(resultp);
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per questo isbn " + isbn);
	    }
	    return resultp;
	}
	
	public static void searchByYearDate(int year) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.annopubblicazione = :year", Pubblicazione.class);
	    query.setParameter("year", year);
	    List<Pubblicazione> resultList = query.getResultList();
	    
	    em.getTransaction().commit();
	    if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per l'anno " + year);
	    }
		
	}
	
	public static void searchByAutore(String autore) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.autore = :autore", Pubblicazione.class);
	    query.setParameter("autore", autore);
	    List<Pubblicazione> resultList = query.getResultList();/*getSingleResult() per cercare solo il primo elemento*/
	    
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata per l'anno " + autore);
	    }
	}
	
	public static void searchByTitolo(String titolo) {
		em.getTransaction().begin();
		
		TypedQuery<Pubblicazione> query = em.createQuery("SELECT p FROM Pubblicazione p WHERE p.titolo like :titolo", Pubblicazione.class);
	    query.setParameter("titolo", '%' + titolo + '%');
	    List<Pubblicazione> resultList = query.getResultList();
	    
		em.getTransaction().commit();
		if (resultList != null && !resultList.isEmpty()) {
	        for (Pubblicazione p : resultList) {
	            System.out.println(p.toString());
	        }
	    } else {
	        System.out.println("Nessuna pubblicazione trovata con titolo: " + titolo);
	    }
	}
	
	public static void dellToCatalogue(Object e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("oggetto eliminato dall'archivio!");
	}
	
	public static void dellToCatalogueById(Long id) {
		em.getTransaction().begin();
		Pubblicazione a = em.find(Pubblicazione.class, id);
		em.remove(a);
		em.getTransaction().commit();
		System.out.println("oggetto selezionato per id eliminato dall'archivio!");
	}
	
	public static void dellPubblicazione(Object a) {
		System.out.println("vuoi eliminare l'oggetto" + a.toString() + "?");
		System.out.println("premi 1 per dire si, premi 0 per dire no");
		int value = input.nextInt();
		input.nextLine();
		switch(value) {
		case 1:
			em.getTransaction().begin();
			em.remove(a);
			em.getTransaction().commit();
			System.out.println("oggetto eliminato dall'archivio!");
			break;
		case 0:
			System.out.println("elemento non eliminato");
			break;
		}
		
	}
		
}