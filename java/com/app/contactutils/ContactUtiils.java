package com.app.contactutils;

import java.rmi.ServerException;

import com.app.entity.Contact;

public class ContactUtiils {

	public static void validateContactForm(Contact contact) throws ServerException {

		if (contact.getConactNumber() == null && contact.getConactNumber()== 0) {
			throw new ServerException("Please Enter Contact Number");
		} else if (contact.getContactEmailId() == null && contact.getContactEmailId()=="" && contact.getContactEmailId().isEmpty()) {
			throw new ServerException("Please Enter EmailId");
		} else if (contact.getContactName() == null && contact.getContactName()=="" && contact.getContactName().isEmpty()) {
			throw new ServerException("Please Enter Contact Name");
		}

	}
}
