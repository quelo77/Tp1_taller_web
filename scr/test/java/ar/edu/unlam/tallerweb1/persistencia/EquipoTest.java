package ar.edu.unlam.tallerweb1.persistencia;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Equipo;
import ar.edu.unlam.tallerweb1.modelo.Jugador;

import static org.assertj.core.api.Assertions.*;

public class EquipoTest extends SpringTest {
	

	@Test @Transactional @Rollback (true)
	public void guardarEquipo () {
		Equipo campeonRacing = new Equipo();
		Session session = getSession();
		session.save(campeonRacing);
		Equipo buscado=session.get(Equipo.class,campeonRacing.getId()); 
		assertThat(buscado).isNotNull();
	}
	@Test @Transactional @Rollback (true)
	public void agregarEquipo () {
		Equipo equipo1 = new Equipo();
		Session session = getSession();
		equipo1.setNombre("boca");
		session.save(equipo1);
		
		String buscado=equipo1.getNombre(); 
		assertThat(buscado).isEqualTo("boca");
	}
	@Test @Transactional @Rollback (true)
	public void testEquiposConMasDe3Campeonatos(){
		List<Jugador> listaEquipos;
		
		Equipo e1=new Equipo();
		Equipo e2=new Equipo();
		Equipo e3=new Equipo();
		Jugador j1=new Jugador();
		Jugador j2=new Jugador();
		Jugador j3=new Jugador();
		
		
		Session session=getSession();
		
		e1.setNombre("RiBer");
		e2.setNombre("San Lorenzo");
		e3.setNombre("Velez");
		e1.setCantidadCampeonatos(1);
		e2.setCantidadCampeonatos(2);
		e3.setCantidadCampeonatos(4);
		
		j1.setNombre("Pepe");
		j1.setEquipo(e3);
		j2.setNombre("Luis");
		j2.setEquipo(e2);
		j3.setNombre("Jose");
		j3.setEquipo(e1);
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(j1);
		
		listaEquipos= (List<Jugador>) session.createCriteria(Jugador.class)
				.createAlias("equipo", "e")
				.add(Restrictions.eq("e.cantidadCampeonatos",4))
				.list();
		assertThat(listaEquipos).hasSize(1);		
		
		
		
	}
	
	
	
	

}
