package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.List;
import jdbc.Persona;
import jdbc.PersonaDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:datasource-test.xml", "classpath:applicationContext.xml" })
public class TestPersonasDaoImpl {
	private static Log logger = LogFactory.getLog("TestPersonasDaoImpl");
	@Autowired
	private PersonaDao personaDao;

	@Test
	public void deberiaEliminarPersona() {
		try {
			System.out.println();
			logger.info("Inicio del test deberiaEliminarPersona");
			// Buscamos eliminar la persona con id = 2
			int idPersona = 2;
			Persona persona = personaDao.findPersonaById(idPersona);
			logger.info("Persona a eliminar (id=" + idPersona + "): " + persona);
			// Eliminamos la persona recuperada
			personaDao.deletePersona(persona);
			persona = personaDao.findPersonaById(idPersona);
			// Deberia de regresar nulo al buscar la persona 2
			assertNull(persona);
			// Imprimimos todo el objeto
			logger.info("Nuevo listado de personas:");
			List<Persona> personas = personaDao.findAllPersonas();
			int contadorPersonas = 0;
			for (Persona persona2 : personas) {
				logger.info("Persona: " + persona2);
				contadorPersonas++;
			}
			// Segun el numero de personas recuperadas, deberia ser el mismo de
			// la tabla
			assertEquals(contadorPersonas, personaDao.contadorPersonas());
			logger.info("Fin del test deberiaEliminarPersona");
			System.out.println();
		} catch (Exception e) {
			logger.error("Error JBDC", e);
		}
	}
}
