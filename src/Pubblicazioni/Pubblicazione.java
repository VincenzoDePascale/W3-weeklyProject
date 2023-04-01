package Pubblicazioni;

import java.io.Serializable;

import javax.persistence.*;

import Prestito.Prestito;

@Entity
@Table(name="pubblicazioni")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name= "tipologia", discriminatorType = DiscriminatorType.STRING)
@NamedQuery(name="pubblicazioni.findAll", query = "SELECT e FROM Pubblicazione e")
public class Pubblicazione implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(nullable = false, unique = true)
    private long isbn;
	
	@Column(nullable = false)
    private String titolo;
	
	@Column(nullable = false)
    private int annopubblicazione;
	
	@Column(nullable = false)
    private int pagine;
	
	@OneToOne(mappedBy = "pubblicazione")
	private Prestito prestito;
	
	public Pubblicazione() {}
	
	    public Pubblicazione(long isbn, String titolo, int annopubblicazione, int pagine) {
		this.isbn = isbn;
		this.titolo = titolo;
		this.annopubblicazione = annopubblicazione;
		this.pagine = pagine;
	}

	public long getId() {
		return id;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public int getAnnopubblicazione() {
		return annopubblicazione;
	}

	public void setAnnopubblicazione(int annopubblicazione) {
		this.annopubblicazione = annopubblicazione;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public Prestito getPrestito() {
		return prestito;
	}

	public void setPrestito(Prestito prestito) {
		this.prestito = prestito;
	}

	
				

}
