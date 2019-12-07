package com.moo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moo.bean.ContactBean;

@RestController
public class ContactController {

	
	@RequestMapping(value="/v1/contact",method=RequestMethod.GET)
	public List<ContactBean> searchContactBySurname(@RequestParam(defaultValue = "") String surname){
		
		
		return null;
	}
}
