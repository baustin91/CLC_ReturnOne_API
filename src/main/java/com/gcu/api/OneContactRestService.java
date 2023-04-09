package com.gcu.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ContactBusinessService;
import com.gcu.model.ContactModel;

@RestController
@RequestMapping("/contacts")
public class OneContactRestService {
	
	@Autowired
	ContactBusinessService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOneContact(@PathVariable(name="id") String search)
	{
		try
		{
			ContactModel order = service.getClient(search);
			if(order == null)
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			
			else {
				return new ResponseEntity<>(order, HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
