package Pubblicazioni;

import java.io.Serializable;
import java.time.*;

import javax.persistence.*;

@Entity
@Table(name = "pubblicazioni")
public class Rivista extends Pubblicazione implements Serializable{
	
	@Enumerated(EnumType.STRING)
	@Column
	private Periodicita periodicita;
    
	public Rivista() {}
	
	public Rivista(long isbn, String titolo, int annopubblicazione, int pagine, Periodicita periodicita) {
		super(isbn, titolo, annopubblicazione, pagine);
		this.periodicita = periodicita;
	}

public Periodicita getPeriodicita() {
		return periodicita;
	}

	public void setPeriodicita(Periodicita periodicita) {
		this.periodicita = periodicita;
	}

	@Override
	public String toString() {
		return "Rivista [periodicita=" + periodicita + ", ISBN=" + getIsbn()
				+ ", titolo=" + getTitolo() + ", anno di pubblicazione=" + getAnnopubblicazione()
				+ ", numero pagine=" + getPagine() + "]\n";
	}

	
       
}