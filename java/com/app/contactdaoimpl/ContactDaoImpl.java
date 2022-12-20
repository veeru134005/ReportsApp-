package com.app.contactdaoimpl;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.contactdao.ContactDao;
import com.app.contactrepositoy.ContactRepository;
import com.app.entity.Contact;
@Repository
public class ContactDaoImpl implements ContactDao {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact saveConact(Contact contact) throws ServerException {
		// TODO Auto-generated method stub

		return contactRepository.save(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public Optional<Contact> getContactById(Integer contactId) {
		return contactRepository.findById(contactId);
	}

	@Override
	public String updateContact(Contact contact) {

		if (contactRepository.existsById(contact.getContactId())) {
			contactRepository.save(contact);
			return "Update Success";
		} else {
			return "No Record Found";
		}
	}

	@Override
	public String deleteConactById(Integer contactId) {

		if (contactRepository.existsById(contactId)) {
			contactRepository.deleteById(contactId);
			return "Record Deleted";
		} else {
			return "No Record Found";
		}

	}
}