package ch.fhnw.person.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;
import ch.fhnw.person.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
    @RequestMapping("/index")
    public String listContacts(Map<String, Object> map) {
    	Address address = new Address();
    	Person person = new Person();
    	person.setAddress(address);
        map.put("person", person);
        map.put("persons", personService.getPersons());
 
        return "person";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person person, BindingResult result) {
        personService.save(person);;

        return "redirect:/index";
    }
 
    @RequestMapping("/delete/{personId}")
    public String deleteContact(@PathVariable("personId") Integer personId) {
 
        personService.delete(personId);
 
        return "redirect:/index";
    }
	
	
}
