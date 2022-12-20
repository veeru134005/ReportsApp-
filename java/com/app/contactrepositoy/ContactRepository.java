package com.app.contactrepositoy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
