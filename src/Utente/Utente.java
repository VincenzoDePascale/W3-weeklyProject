package Utente;

import java.io.Serializable;
import java.time.*;

import javax.persistence.*;

import Prestito.Prestito;

@Entity
@Table(name="utenti")
@NamedQuery(name="utenti.findAll", query = "SELECT e FROM Utente e")
public class Utente implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private LocalDate nascita;
	
	@Column(nullable = false, unique = true)
	private Long tessera;
	
	@OneToOne(mappedBy = "utente")
	private Prestito prestito;

	public Utente() {}
	
	public Utente(String nome, String cognome, LocalDate nascita, Long tessera) {
		this.nome = nome;
		this.cognome = cognome;
		this.nascita = nascita;
		this.tessera = tessera;
	}

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public LocalDate getNascita() {
		return nascita;
	}

	public void setNascita(LocalDate nascita) {
		this.nascita = nascita;
	}

	public Long getTessera() {
		return tessera;
	}

	public void setTessera(Long tessera) {
		this.tessera = tessera;
	}
	
	

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

	@Override
	public String toString() {
		return "Utente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", nascita=" + nascita + ", tessera="
				+ tessera + "]";
	}
	
}
