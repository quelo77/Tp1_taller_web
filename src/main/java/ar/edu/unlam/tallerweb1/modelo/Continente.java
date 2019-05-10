package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Continente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idContinente;
	private String nombre;

	
	
	public Continente(Long idContinente, String nombre) {
		super();
		this.idContinente = idContinente;
		this.nombre = nombre;
	}
	
	public Continente() {
		super();
		
	}
	public Long getIdContinente() {
		return idContinente;
	}

	public void setId(Long id) {
		this.idContinente = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
