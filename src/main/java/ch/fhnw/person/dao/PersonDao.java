package ch.fhnw.person.dao;

import java.util.List;

import ch.fhnw.person.model.Person;

public interface PersonDao {
	
	public void save(Person person);
	public void delete(Person person);
	public void delete(Integer id);
	public Person findPersonById(Integer id);
	public List<Person> getPersons();

}
