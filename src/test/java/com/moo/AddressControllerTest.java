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

import com.moo.bean.AddressBean;
import com.moo.controller.AddressController;
import com.moo.exception.NoDataFoundException;
import com.moo.service.AddressService;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {

	@InjectMocks
	AddressController addressController;

	@Mock
	AddressService addressService;

	/**
	 * Test to check success scenario
	 */
	@Test
	public void successScenarioTest() {

		List<AddressBean> addressBeanList = new ArrayList<AddressBean>();

		AddressBean addressBean = new AddressBean();
		addressBean.setAddressId(1L);
		addressBean.setContactId(1L);
		addressBean.setPostcode("AL13QR");
		addressBean.setPrimaryContact(true);
		addressBean.setSteetName("Hillside Road");
		addressBeanList.add(addressBean);

		when(addressService.getAddressByContactId(1L)).thenReturn(addressBeanList);

		List<AddressBean> addressBeanListActural = addressController.getContactAddress(1L);

		assertTrue(addressBeanListActural.size() == 1);

	}

	/**
	 * Test to check 404 No data found error
	 * 
	 */
	@Test
	public void noDataFoundTest() {
		List<AddressBean> addressList = new ArrayList<>();
		
		when(addressService.getAddressByContactId(1L)).thenReturn(addressList);

		Assertions.assertThrows(NoDataFoundException.class, () -> addressController.getContactAddress(1L));
	}

}
