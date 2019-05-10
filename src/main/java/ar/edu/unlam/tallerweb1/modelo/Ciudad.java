package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ciudad {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCiudad;
	@OneToOne
	private Ubicacion ubicacionGeo;
	private String nombre;
	@ManyToOne
	private Pais pais;
	
	public Ciudad(Long idCiudad, Ubicacion ubicacionGeo, String nombre,
			Pais pais) {
		super();
		this.idCiudad = idCiudad;
		this.ubicacionGeo = ubicacionGeo;
		this.nombre = nombre;
		this.pais = pais;
	}
	public Ciudad() {
	
		
	}
	public Long getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}
	public Ubicacion getUbicacionGeo() {
		return ubicacionGeo;
	}
	public void setUbicacionGeo(Ubicacion ubicacionGeo) {
		this.ubicacionGeo = ubicacionGeo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	

}

