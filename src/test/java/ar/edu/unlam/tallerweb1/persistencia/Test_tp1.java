package ar.edu.unlam.tallerweb1.persistencia;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Ciudad;
import ar.edu.unlam.tallerweb1.modelo.Continente;
import ar.edu.unlam.tallerweb1.modelo.Pais;
import ar.edu.unlam.tallerweb1.modelo.Ubicacion;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;


public class Test_tp1 extends SpringTest{

	@Test 
	@Rollback(true) 
	@Transactional
	//Test que busque todos los países de habla inglesa.  
	public void test1(){
		List<Ciudad> listaPaises;
		//creamos los objetos
		Pais p1= new Pais();
		Pais p2= new Pais();
		Pais p3= new Pais();
		Pais p4= new Pais();
		Pais p5= new Pais();
		Pais p6= new Pais();
		Ciudad c1= new Ciudad();
		Ciudad c2= new Ciudad();
		Ciudad c3= new Ciudad();
		Ciudad c4= new Ciudad();
		Ciudad c5= new Ciudad();
		Ciudad c6= new Ciudad();
		
		Session session= getSession();
		
		p1.setNombre("Argentina");
		p2.setNombre("Brasil");
		p3.setNombre("Canada");
		p4.setNombre("Japon");
		p5.setNombre("Portugal");
		p6.setNombre("Alemania");
		p1.setIdioma("Castellano");
		p2.setIdioma("Portugues");
		p3.setIdioma("Ingles");
		p2.setIdioma("Japones");
		p2.setIdioma("Portugues");
		p2.setIdioma("Aleman");
		c1.setNombre("La plata");
		c2.setNombre("Buenos Aires");
		c3.setNombre("Ottawa");
		c4.setNombre("Brasilia");
		c5.setNombre("Berlin");
		c6.setNombre("Lisboa");
		c1.setPais(p1);
		c2.setPais(p1);
		c3.setPais(p3);
		c4.setPais(p2);
		c5.setPais(p6);
		c6.setPais(p5);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		session.save(p6);
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		session.save(c5);
		session.save(c6);
		
		listaPaises=session.createCriteria(Ciudad.class)
					.createAlias("pais", "p")
					.add(Restrictions.eq("p.idioma","Ingles"))
					.list();
				assertThat(listaPaises).hasSize(1);
	}
	@Test 
	@Rollback(true) 
	@Transactional
	//Test que busque todos los paises del continente europeo 
	public void test2(){
		
		List<Pais> listaEuropa;
		
		Pais p1= new Pais();
		Pais p2= new Pais();
		Pais p3= new Pais();
		Pais p4= new Pais();
		Pais p5= new Pais();
		Pais p6= new Pais();
		Continente co1= new Continente();
		Continente co2= new Continente();
		Continente co3= new Continente();
		Continente co4= new Continente();
		Continente co5= new Continente();
		
		Session session= getSession();
		
		p1.setNombre("Argentina");
		p2.setNombre("Brasil");
		p3.setNombre("Canada");
		p4.setNombre("Japon");
		p5.setNombre("Portugal");
		p6.setNombre("Alemania");
		co1.setNombre("America");
		co2.setNombre("Europa");
		co3.setNombre("Asia");
		co4.setNombre("Africa");
		co5.setNombre("Oceania");
		p1.setContinente(co1);
		p2.setContinente(co1);
		p3.setContinente(co1);
		p4.setContinente(co3);
		p5.setContinente(co2);
		p6.setContinente(co2);
		
		session.save(p1);
		session.save(p2);
		session.save(p3);
		session.save(p4);
		session.save(p5);
		session.save(p6);
		session.save(co1);
		session.save(co2);
		session.save(co3);
		session.save(co4);
		session.save(co5);
		
		listaEuropa=session.createCriteria(Pais.class)
				.createAlias("continente", "c")
				.add(Restrictions.eq("c.nombre","Europa"))
				.list();
				assertThat(listaEuropa).hasSize(2);
		
	}
	
	@Test 
	@Rollback(true) 
	@Transactional
	//Test que busque todos los países cuya capital están al norte del trópico de cáncer
	public void test3(){
		Pais p1= new Pais();
		Pais p2= new Pais();
		Pais p3= new Pais();
		Pais p4= new Pais();
		Pais p5= new Pais();
		Pais p6= new Pais();
		Ubicacion u1= new Ubicacion();
		Ubicacion u2= new Ubicacion();
		Ubicacion u3= new Ubicacion();
		Ubicacion u4= new Ubicacion();
		Ubicacion u5= new Ubicacion();
		Ubicacion u6= new Ubicacion();
		Ciudad c1= new Ciudad();
		Ciudad c2= new Ciudad();
		Ciudad c3= new Ciudad();
		Ciudad c4= new Ciudad();
		Ciudad c5= new Ciudad();
		Ciudad c6= new Ciudad();
		
		Session session= getSession();
		
		p1.setNombre("Argentina");
		p2.setNombre("Brasil");
		p3.setNombre("Canada");
		p5.setNombre("Portugal");
		p6.setNombre("Alemania");
		
		c1.setNombre("La plata");
		c2.setNombre("Buenos Aires");
		c3.setNombre("Ottawa");
		c4.setNombre("Brasilia");
		c5.setNombre("Berlin");
		c6.setNombre("Lisboa");
		
		p1.setCapital("La Plata");
		p2.setCapital("Mexico");
		p3.setCapital("Ottawa");
		p5.setCapital("Lisboa");
		p6.setCapital("Berlin");
		
		
		u1.setLatitud(34.2541);
		u1.setLongitud(64.546);
		u2.setLatitud(23.26129);
		u2.setLongitud(30.1201);
		u3.setLatitud(12.586);
		u3.setLongitud(95.64);
		u4.setLatitud(65.985);
		u4.setLongitud(14.74);
		u5.setLongitud(65.85);
		u5.setLatitud(75.15);
		u6.setLatitud(45.23);
		u6.setLongitud(45.10);
		
		c1.setPais(p1);
		c2.setPais(p1);
		c3.setPais(p3);
		c4.setPais(p2);
		c5.setPais(p6);
		c6.setPais(p5);
		
		c1.setUbicacionGeo(u1);
		c2.setUbicacionGeo(u2);
		c3.setUbicacionGeo(u3);
		c4.setUbicacionGeo(u4);
		c5.setUbicacionGeo(u5);
		c6.setUbicacionGeo(u6);
		
		List<Pais> paisesDelnorteDelTropicoDeCancer=session.createCriteria(Pais.class)
				.createAlias("capital", "cap")
				.createAlias("cap.ubicacionGeo","u")
				.add(Restrictions.gt("u.latitud", 23.43))
				.list();
		assertThat(paisesDelnorteDelTropicoDeCancer).isNotNull();
		assertThat(paisesDelnorteDelTropicoDeCancer.size()).isEqualTo(1);
	
	}
	@Test 
	@Rollback(true) 
	@Transactional
	//Test que busque todas las ciudades del hemisferio sur
	public void test4(){
		Ciudad c1= new Ciudad();
		Ciudad c2= new Ciudad();
		Ciudad c3= new Ciudad();
		Ciudad c4= new Ciudad();
		Ciudad c5= new Ciudad();
		Ciudad c6= new Ciudad();
		Ubicacion u1= new Ubicacion();
		Ubicacion u2= new Ubicacion();
		Ubicacion u3= new Ubicacion();
		Ubicacion u4= new Ubicacion();
		Ubicacion u5= new Ubicacion();
		Ubicacion u6= new Ubicacion();
		Session session= getSession();
		
		c1.setNombre("La plata");
		c2.setNombre("Buenos Aires");
		c3.setNombre("Ottawa");
		c4.setNombre("Brasilia");
		c5.setNombre("Berlin");
		c6.setNombre("Lisboa");
		u1.setLatitud(34.2541);
		u1.setLongitud(64.546);
		u2.setLatitud(23.26129);
		u2.setLongitud(30.1201);
		u3.setLatitud(12.586);
		u3.setLongitud(95.64);
		u4.setLatitud(65.985);
		u4.setLongitud(14.74);
		u5.setLongitud(65.85);
		u5.setLatitud(75.15);
		u6.setLatitud(45.23);
		u6.setLongitud(45.10);
		
		c1.setUbicacionGeo(u1);
		c2.setUbicacionGeo(u2);
		c3.setUbicacionGeo(u3);
		c4.setUbicacionGeo(u4);
		c5.setUbicacionGeo(u5);
		c6.setUbicacionGeo(u6);
		List<Ciudad> paisesDelHemisferioSur=session.createCriteria(Ciudad.class)
				.createAlias("ubicacionGeo","u")
				.add(Restrictions.le("u.latitud", 23.43))
				.list();
		assertThat(paisesDelHemisferioSur).isNotNull();
		assertThat(paisesDelHemisferioSur.size()).isEqualTo(1);
		
	}
	
}
