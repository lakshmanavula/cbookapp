package com.careerit.cbook.service;

import java.util.List;

import com.careerit.cbook.dao.ContactDao;
import com.careerit.cbook.dao.ContactDaoImpl;
import com.careerit.cbook.domain.Contact;

public class ContactServiceImpl implements ContactService{

	private ContactDao contactDao = new ContactDaoImpl();
	@Override
	public int addContact(Contact contact) {
		//Logic validate
		return contactDao.insertContact(contact);
	}

	@Override
	public List<Contact> getContacts() {
		List<Contact> contacts = contactDao.selectContacts();
		return contacts;
	}

	@Override
	public Contact updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact getContactById(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> search(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteContact(int cid) {
		// TODO Auto-generated method stub
		return false;
	}

}
