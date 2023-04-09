package com.gcu.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ContactDataService;
import com.gcu.model.ContactModel;

@Service
public class ContactBusinessService implements ContactBusinessServiceInterface {

	@Autowired
	ContactDataService contactDataService;
	
	@Override
	public ContactModel getClient(String search) {
		ContactModel client = contactDataService.findOne(search);
		
		return client;
	}

}
