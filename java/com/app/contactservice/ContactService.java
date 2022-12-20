package com.app.contactservice;

import java.rmi.ServerException;
import java.util.List;

import com.app.entity.Contact;


public interface ContactService {

	public String saveConact(Contact contact) throws ServerException;

	public List<Contact> getAllContacts();

	public Contact getContactById(Integer contactId);

	public String updateContact(Contact contact) throws ServerException;

	public String deleteConactById(Integer contactId);

}
