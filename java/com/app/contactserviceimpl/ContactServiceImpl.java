package com.app.contactserviceimpl;

import java.rmi.ServerException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.contactdao.ContactDao;
import com.app.contactservice.ContactService;
import com.app.contactutils.ContactUtiils;
import com.app.entity.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao contactDao;

	@Override
	public String saveConact(Contact contact) throws ServerException {

		ContactUtiils.validateContactForm(contact);

		contact = contactDao.saveConact(contact);

		if (contact.getContactId() != null) {
			return "Contact Saved";
		} else {
			return "Contact failed to saved";
		}
	}

	@Override
	public List<Contact> getAllContacts() {

		return contactDao.getAllContacts();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> contactById = contactDao.getContactById(contactId);
		if (contactById.isPresent()) {
			return contactById.get();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) throws ServerException {

		ContactUtiils.validateContactForm(contact);

		return contactDao.updateContact(contact);
	}

	@Override
	public String deleteConactById(Integer contactId) {
		return contactDao.deleteConactById(contactId);
	}

}
