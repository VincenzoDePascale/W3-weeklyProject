package Pubblicazioni;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "pubblicazioni")

public class Libro extends Pubblicazione implements Serializable{
	
	@Column
	private String autore;
	
	@Column
	private String genere;

	public Libro() {}
	
	public Libro(long isbn, String titolo, int annopubblicazione, int pagine, String autore, String genere) {
		super(isbn, titolo, annopubblicazione, pagine);
		this.autore = autore;
		this.genere = genere;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	@Override
	public String toString() {
		return "Libro [autore=" + autore + ", genere=" + genere + ", ISBN=" + getIsbn()
				+ ", titolo=" + getTitolo() + ", anno di pubblicazione=" + getAnnopubblicazione()
				+ ", numero pagine=" + getPagine() + "]\n";
	}

	
}
