package com.moo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moo.bean.ContactBean;
import com.moo.entity.ContactEntity;
import com.moo.repository.ContactRepository;

@Component
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	public List<ContactBean> searchContactBySurname(String surname) {

		List<ContactEntity> contactEntityList = contactRepository.getContactBySurname(surname);

		List<ContactBean> contactBeanList = new ArrayList<ContactBean>();

		for (ContactEntity contactEntity : contactEntityList) {
			ContactBean contact = new ContactBean();
			contact.setContactId(contactEntity.getId());
			contact.setFirstName(contactEntity.getFirstName());
			contact.setSurname(contactEntity.getSurname());
			contactBeanList.add(contact);
		}

		return contactBeanList;
	}

}
