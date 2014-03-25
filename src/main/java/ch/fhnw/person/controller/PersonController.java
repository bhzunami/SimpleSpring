package ch.fhnw.person.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ch.fhnw.person.model.Address;
import ch.fhnw.person.model.Person;
import ch.fhnw.person.service.PersonService;

@Controller
public class PersonController {

	@Autowired
	private PersonService personService;
	
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
    	Address address = new Address();
    	Person person = new Person();
    	person.setAddress(address);
        map.put("person", person);
        map.put("persons", personService.getPersons());
        System.out.println("PERSON");
        return "person";
    }
    
    @RequestMapping(value = "/inde", method = RequestMethod.GET)
    public String index(Map<String, Object> map) {
    	return listContacts(map);
    }
 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addPerson(@Valid Person person, BindingResult result, Model m) {
    	if(result.hasErrors()) {
    		//return "redirect:/index";
    		return "person";
        }
    	personService.save(person);
    	m.addAttribute("message", "Successfully saved person: " + person.toString());
    	//return "redirect:/index";
    	return "redirect:/";
        
    }
 
    @RequestMapping("/delete/{personId}")
    public String deleteContact(@PathVariable("personId") Integer personId) {
 
        personService.delete(personId);
 
        return "redirect:/index";
    }
	
	
}
