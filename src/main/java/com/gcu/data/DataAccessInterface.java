package com.gcu.data;

import java.util.List;

import com.gcu.model.ContactModel;

public interface DataAccessInterface<T> {

	List<T> findAll();
	ContactModel findOne(String search);
}
