package com.app.controller;

import java.rmi.ServerException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.contactservice.ContactService;
import com.app.entity.Contact;

@RestController
@RequestMapping(value = "/api/v1")
@CrossOrigin(value="http://localhost:4200")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@PostMapping(value = "/contact")
	public String saveConact(@RequestBody Contact contact) throws ServerException {
		return contactService.saveConact(contact);
	}

	@GetMapping(value = "/contacts")
	public List<Contact> getAllContacts() {

		return contactService.getAllContacts();
	}

	@GetMapping(value = "/contact/{contactId}")
	public Contact getContactById(@PathVariable Integer contactId) {
		return contactService.getContactById(contactId);
	}

	@PutMapping(value = "/contact")
	public String updateContact(@RequestBody Contact contact) throws ServerException {
		return contactService.updateContact(contact);
	}

	@DeleteMapping(value = "contact/{contactId}")
	public String deleteConactById(@PathVariable Integer contactId) {

		return contactService.deleteConactById(contactId);
	}

}
