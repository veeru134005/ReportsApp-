package com.app.contactdao;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import com.app.entity.Contact;


public interface ContactDao {

	public Contact saveConact(Contact contact) throws ServerException;

	public List<Contact> getAllContacts();

	public Optional<Contact> getContactById(Integer contactId);

	public String updateContact(Contact contact);

	public String deleteConactById(Integer contactId);
}
