package ch.fhnw.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ch.fhnw.person.dao.PersonDao;
import ch.fhnw.person.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired 
	private PersonDao personDao;

	@Transactional
	public void save(Person person) {
		personDao.save(person);
		
	}

	@Transactional
	public void delete(Person person) {
		personDao.delete(person);
		
	}

	@Transactional
	public Person findPersonById(Integer id) {
		return personDao.findPersonById(id);
	}

	@Transactional
	public List<Person> getPersons() {
		return personDao.getPersons();
	}
	
	@Transactional
	public void delete(Integer id) {
		personDao.delete(id);
	}

}
