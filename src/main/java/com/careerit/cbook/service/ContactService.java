package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactService {

	public int addContact(Contact contact);

	public List<Contact> getContacts();

	public Contact updateContact(Contact contact);

	public Contact getContactById(int cid);

	public List<Contact> search(String str);

	public boolean deleteContact(int cid);

}
