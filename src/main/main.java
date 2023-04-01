package main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Prestito.*;
import Pubblicazioni.*;
import Utente.*;


public class main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("W3-weeklyProject-java");
	static EntityManager em = emf.createEntityManager();

	public static void main(String[] args){
		
		List<Pubblicazione> listaPubblicazioni = ArchivioDAO.findAllCatalogo();
		List<Utente> listaUtenti = UtentiDAO.findAllUtenti();
		List<Prestito> listPrestiti = PrestitiDAO.findAllPrestiti();
		
		try{
			
			Libro L1 = new Libro();
			L1.setIsbn(91l);
			L1.setTitolo("titoloLibro1");
			L1.setAutore("autorelibro1");
			L1.setGenere("generelibro1");
			L1.setPagine(111);
			L1.setAnnopubblicazione(2022);
			addElement(L1);
						
			Rivista R1 = new Rivista();
			R1.setIsbn(92l);
			R1.setTitolo("titoloRivista1");
			R1.setPagine(11);
			R1.setAnnopubblicazione(2022);
			R1.setPeriodicita(Periodicita.MENSILE);
			addElement(R1);
			
			Utente U1 = new Utente();
	    	U1.setNome("gennaro");
	    	U1.setCognome("savastano");
	    	U1.setNascita(LocalDate.of(1962, 5, 7));
	    	U1.setTessera(1001l);
	    	addElement(U1);
	    	  
	    	Utente U2 = new Utente();
	    	U2.setNome("maria");
	    	U2.setCognome("silvani");
	    	U2.setNascita(LocalDate.of(1999, 9, 1));
	    	U2.setTessera(1002l);
	    	addElement(U2);
	    	
			Prestito p1 = new Prestito();
	        p1.setDataprestito(LocalDate.of(2022, 1, 1));
	        p1.setDatarestituzioneprevista(LocalDate.of(2022, 2, 1));
	        p1.setPubblicazione(ArchivioDAO.serchByIsbn(91l));
	        p1.setUtente(UtentiDAO.searchById(2l));
	        PrestitiDAO.addPrestito(p1);
	        
	        System.out.println(listPrestiti);
						
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			em.close();
		}
		
	}

	public static void addElement(Object e) {
		
		if (e != null) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
				
		if(e instanceof Pubblicazione) {
			System.out.println("pubblicazione salvata con successo!");
		} else if (e instanceof Utente){
			System.out.println("rivista salvato con successo!");
		}else if (e instanceof Prestito){
			System.out.println("utente salvato con successo!");
		}
		
		}else {
			System.out.println("ERRORE: dati inseriti non validi!");
		}
		
		
		
	}
	
	public static void dellElement(Object e) {
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		System.out.println("oggetto eliminato con successo!");
	}
	
}