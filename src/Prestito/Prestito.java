package Prestito;

import java.io.Serializable;
import java.time.*;

import javax.persistence.*;

import Pubblicazioni.Pubblicazione;
import Utente.Utente;

@Entity
@Table(name="prestiti")
@NamedQuery(name="prestiti.findAll", query = "SELECT e FROM Prestito e")
public class Prestito implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@OneToOne
	@JoinColumn(name = "prestito_utente")
	private Utente utente;
	
	@OneToOne
	@JoinColumn(name = "prestito_pubblicazione")
	private Pubblicazione pubblicazione;
	
	@Column(nullable = false)
	private LocalDate dataprestito;
	
	@Column(nullable = false)
	private LocalDate datarestituzioneprevista = dataprestito.plusDays(30);
	
	@Column
	private LocalDate datarestituzioneeffettuata;

	public Prestito() {}
	
	public Prestito(Utente utente, Pubblicazione pubblicazione, LocalDate dataprestito,
			 LocalDate datarestituzioneeffettuata) {
		this.utente = utente;
		this.pubblicazione = pubblicazione;
		this.dataprestito = dataprestito;
		this.datarestituzioneprevista = dataprestito.plusDays(30);
		this.datarestituzioneeffettuata = datarestituzioneeffettuata;
	}
	
	public long getId() {
		return id;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Pubblicazione getPubblicazione() {
		return pubblicazione;
	}

	public void setPubblicazione(Pubblicazione pubblicazione) {
		this.pubblicazione = pubblicazione;
	}

	public LocalDate getDataprestito() {
		return dataprestito;
	}

	public void setDataprestito(LocalDate dataprestito) {
		this.dataprestito = dataprestito;
	}

	public LocalDate getDatarestituzioneprevista() {
		return datarestituzioneprevista;
	}

	public void setDatarestituzioneprevista(LocalDate datarestituzioneprevista) {
		this.datarestituzioneprevista = datarestituzioneprevista;
	}

	public LocalDate getDatarestituzioneeffettuata() {
		return datarestituzioneeffettuata;
	}

	public void setDatarestituzioneeffettuata(LocalDate datarestituzioneeffettuata) {
		this.datarestituzioneeffettuata = datarestituzioneeffettuata;
	}

	
	
	@Override
	public String toString() {
		return "Prestito [utente=" + utente + ", pubblicazione=" + pubblicazione + ", dataprestito="
				+ dataprestito + ", datarestituzioneprevista=" + datarestituzioneprevista
				+ ", datarestituzioneeffettuata=" + datarestituzioneeffettuata + "]";
	}

	

}
