package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.gcu.mapper.ContactMapper;
import com.gcu.model.ContactModel;

@Service
public class ContactDataService implements DataAccessInterface<ContactModel> {

	DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public ContactDataService (DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ContactModel> findAll() {
		List<ContactModel> result = jdbcTemplateObject.query("SELECT * FROM client", new ContactMapper());
		return result;
		
	}

	@Override
	public ContactModel findOne(String search) {
		
		List<ContactModel> results = jdbcTemplateObject.query("SELECT * FROM client WHERE id = ?", new ContactMapper(), search);
		
		if (results.size() > 0)
			return results.get(0);
		else
			return null;
	}

}
