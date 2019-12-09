package com.moo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moo.bean.AddressBean;
import com.moo.entity.AddressEntity;
import com.moo.repository.AddressRepository;

@Component
public class AddressService {

	@Autowired
	AddressRepository addressRepository;

	public List<AddressBean> getAddressByContactId(Long contactId) {

		List<AddressEntity> addressEntityList = addressRepository.getAddressByContactId(contactId);
		
		List<AddressBean> addressBeanList = new ArrayList<AddressBean>();
		
		// map from entity bean to response bean
		for (AddressEntity addressEntity : addressEntityList) {
			AddressBean addressBean = new AddressBean();
			addressBean.setAddressId(addressEntity.getId());
			addressBean.setContactId(addressEntity.getContactIdFk());
			addressBean.setPostcode(addressEntity.getPostcode());
			addressBean.setPrimaryContact(addressEntity.isPrimaryAddress());
			addressBean.setSteetName(addressEntity.getStreetName());
			addressBeanList.add(addressBean);
		}

		return addressBeanList;
	}

}
