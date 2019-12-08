package com.moo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moo.bean.ContactBean;
import com.moo.exception.BadRequestException;
import com.moo.exception.NoDataFoundException;
import com.moo.service.ContactService;

/**
 * 
 * Controller class to manage CRUD from contact
 * 
 * @author Ajay
 *
 */
@RestController
public class ContactController {

	/**
	 * Instance of contact service to manger
	 */
	@Autowired
	ContactService contactService;

	/**
	 * Method to search for a contact using surname
	 *
	 * @param surname
	 *            A String to search for a contact. Surname is mandatory
	 * 
	 * @return A List of contacts
	 * 
	 * @throws BadRequestException
	 *             if surname is not passed.
	 * 
	 * @throws NoDataFoundException
	 *             if surname does not match any record.
	 */
	@RequestMapping(value = "/v1/contact", method = RequestMethod.GET)
	public List<ContactBean> searchContactBySurname(@RequestParam(defaultValue = "") String surname) {

		if (surname == null || surname.isEmpty()) {
			throw new BadRequestException("surname is mandatory query param to search");
		}

		List<ContactBean> contactList = contactService.searchContactBySurname(surname);

		if (contactList.size() == 0) {
			throw new NoDataFoundException("No data found for given criteria surname = " + surname);
		}

		return contactList;
	}
}
