package com.surya.service;


import java.util.List;

import com.surya.entity.Contact;

public interface ContactService {
	
	public String upsert(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContact(Integer id);
	
	public String deleteContact(Integer id);
	
}
