package com.surya.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.surya.entity.Contact;
import com.surya.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	public ContactRepository repository;

	@Override
	public String upsert(Contact contact) {
		Contact contact2=repository.save(contact);
		return "saved";
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts=repository.findAll();
		
		return contacts;
	}

	@Override
	public Contact getContact(Integer id) {
		Optional<Contact> findBid=repository.findById(id);
		if(findBid.isPresent()) {
			return findBid.get();
		}
		return null;
	}

	@Override
	public String deleteContact(Integer id) {
		repository.deleteById(id);
		return "deleted";
	}

}
