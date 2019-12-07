package com.moo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moo.bean.ContactBean;
import com.moo.exception.BadRequestException;
import com.moo.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@RequestMapping(value="/v1/contact",method=RequestMethod.GET)
	public List<ContactBean> searchContactBySurname(@RequestParam(defaultValue = "") String surname){
		
		if (surname == null || surname.isEmpty()) {
			throw new BadRequestException("surname is mandatory query param to search");
		}
		
		List<ContactBean> contactsList = contactService.searchContactBySurname(surname);
		
		return contactsList;
	}
}
