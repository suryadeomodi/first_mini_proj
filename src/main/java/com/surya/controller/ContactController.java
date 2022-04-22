package com.surya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.surya.entity.Contact;
import com.surya.service.ContactService;
import com.surya.service.ContactServiceImpl;

@RestController
@RequestMapping("/api")
public class ContactController {
	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	public ResponseEntity<String> contact(@RequestBody Contact contact) {
		String status = service.upsert(contact);

		return new ResponseEntity<>(status, HttpStatus.CREATED);

	}

	@GetMapping("/contacts")
	public ResponseEntity<List<Contact>> getAllContacts() {
		List<Contact> contacts = service.getAllContacts();

		return new ResponseEntity<List<Contact>>(contacts, HttpStatus.OK);
	}

	@GetMapping("/contact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable int cid) {
		Contact contact = service.getContact(cid);

		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}
	
	@DeleteMapping("/contact/{cid}")
	public ResponseEntity<String> deleteContact(@PathVariable int cid){
		
		String deleteContact=service.deleteContact(cid);
		
		return new ResponseEntity<String>(deleteContact, HttpStatus.OK);
	}

}
