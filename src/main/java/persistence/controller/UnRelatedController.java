package persistence.controller;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;

import persistence.daos.UnRelatedDao;
import persistence.entities.Gender;
import persistence.entities.UnRelatedEntity;

@Controller
public class UnRelatedController {
	@Autowired
    private UnRelatedDao unRelatedDao;
	
	public void process() {
        String[] list = {"0", "1", "2", "3", "4"};
        UnRelatedEntity entity = new UnRelatedEntity("Mi Nick", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence");
        unRelatedDao.save(entity);
        unRelatedDao.save(new UnRelatedEntity("Mi Nick1", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        unRelatedDao.save(new UnRelatedEntity("Mi Nick2", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        unRelatedDao.save(new UnRelatedEntity("Mi Nick3", Gender.MALE, new GregorianCalendar(1964, 11, 31), "...", list,
                Arrays.asList(list), "no persistence"));
        System.out.println(">>>> UnRelatedEntity:  " + unRelatedDao.findOne(entity.getId()));
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findByNickIgnoreCase("mi nick").toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findByNickIgnoreCase("mi nicky").toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(entity.toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findById(1).toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findByIdGreaterThan(1, new PageRequest(0, 5)).toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findAll().toString());
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||||||||");
        System.out.println(unRelatedDao.findAllSQL().toString());
        
    }
}
