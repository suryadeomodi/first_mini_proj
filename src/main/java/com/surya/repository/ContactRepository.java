package com.surya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surya.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
