package com.careerit.cbook.dao;

import java.util.List;

import com.careerit.cbook.domain.Contact;

public interface ContactDao {

	public int insertContact(Contact contact);

	public List<Contact> selectContacts();

	public Contact updateContact(Contact contact);

	public Contact selectContactById(int cid);

	public List<Contact> search(String str);

	public boolean deleteContact(int cid);
}
