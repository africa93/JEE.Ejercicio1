package persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import persistence.daos.PersonaDao;
import persistence.entities.CocheEntity;
import persistence.entities.PersonaEntity;

@Controller
public class PersonaController {
	@Autowired
	private PersonaDao personaDao;
	
	public void process(){
		CocheEntity coche = new CocheEntity("2222LLL","Seat Mii");
		PersonaEntity persona = new PersonaEntity("Africa", coche);
		personaDao.save(persona);
		
		System.out.println(">>>> PersonaEntity:     "+personaDao.findOne(persona.getId()));
	}
}
