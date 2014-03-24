package ch.fhnw.person.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ch.fhnw.person.model.Person;

/*
 * Data access layer of our application consist of one PersonDao Interface 
 * and its implementation PersonDaoImpl class. 
 * The PersonDaoImpl class has a @Repository annotation which used to enable this class 
 * to eligible for persistence exception translation.
 */
@Repository
public class PersonDaoImpl implements PersonDao {
	
	@Autowired
	private SessionFactory sessionFactory;


	public void save(Person person) {
		sessionFactory.getCurrentSession().saveOrUpdate(person);
		
	}

	public void delete(Person person) {
		sessionFactory.getCurrentSession().delete(person);
		
	}

	public Person findPersonById(Integer id) {
		return (Person) sessionFactory.getCurrentSession().load(Person.class, id);
	}

	public List<Person> getPersons() {
		return sessionFactory.getCurrentSession()
				.createQuery("from Person").list();
	}

	public void delete(Integer id) {
		Person person = this.findPersonById(id);
		this.delete(person);
	}
}
