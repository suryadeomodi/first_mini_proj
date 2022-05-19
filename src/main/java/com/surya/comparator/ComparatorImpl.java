package com.surya.comparator;

import java.util.Comparator;

import com.surya.entity.Contact;

public class ComparatorImpl implements Comparator<Contact> {

	@Override
	public int compare(Contact c1, Contact c2) {
		return c1.getEmail().compareTo(c2.getEmail());
	}

}
