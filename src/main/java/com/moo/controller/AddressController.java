package com.moo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moo.bean.AddressBean;
import com.moo.exception.NoDataFoundException;
import com.moo.service.AddressService;

import io.swagger.annotations.Api;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * Controller class to manage CRUD from contact address
 * 
 * @author Ajay
 *
 */
@RestController
@EnableSwagger2
@Api(tags = {"Address"})

public class AddressController {

	@Autowired
	AddressService addresService;

	/**
	 * Method to retrieve contact address
	 * 
	 * @param id contact id
	 * 
	 * @return List of Address for the give contact
	 *
	 * @throws NoDataFoundException
	 *             if contact id  does not have any address associated with it.
	 */
	@RequestMapping(value = "/v1/contact/{id}/address", method = RequestMethod.GET ,  produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<AddressBean> getContactAddress(@PathVariable("id") long id) {

		List<AddressBean> addressList = addresService.getAddressByContactId(id);

		if (addressList.size() == 0) {
			throw new NoDataFoundException("No address found for given contact Id " + id);
		}

		return addressList;
	}

}
