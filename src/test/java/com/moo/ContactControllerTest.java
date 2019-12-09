package com.moo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.moo.bean.ContactBean;
import com.moo.controller.ContactController;
import com.moo.exception.BadRequestException;
import com.moo.exception.NoDataFoundException;
import com.moo.service.ContactService;

@ExtendWith(MockitoExtension.class)

public class ContactControllerTest {

	@InjectMocks
	ContactController contactController;

	@Mock
	ContactService contactService;

	/**
	 * Test to check success scenario
	 */
	@Test
	public void successScenarioTest() {

		List<ContactBean> contactList = new ArrayList<>();
		ContactBean contactBean = new ContactBean();
		contactBean.setContactId(1L);
		contactBean.setFirstName("Ajay");
		contactBean.setSurname("Kannan");
		contactList.add(contactBean);

		when(contactService.searchContactBySurname("kannan")).thenReturn(contactList);

		List<ContactBean> contactListActual = contactController.searchContactBySurname("kannan");

		assertTrue(contactListActual.size() == 1);
	}

	/**
	 * Test to check 404 No data found error
	 * 
	 */
	@Test
	public void noDataFoundTest() {
		List<ContactBean> contactList = new ArrayList<>();
		when(contactService.searchContactBySurname("kannan")).thenReturn(contactList);

		Assertions.assertThrows(NoDataFoundException.class, () -> contactController.searchContactBySurname("kannan"));
	}

	/**
	 * Test to check 400 Bad Request found error when no parameter is found
	 * 
	 */
	@Test
	public void badRequestTest() {

		Assertions.assertThrows(BadRequestException.class, () -> contactController.searchContactBySurname(""));
	}

	/**
	 * Test to check 400 Bad Request error when null parameter is found
	 * 
	 */
	@Test
	public void badRequestWithNullSurnameTest() {

		Assertions.assertThrows(BadRequestException.class, () -> contactController.searchContactBySurname(null));
	}

}
