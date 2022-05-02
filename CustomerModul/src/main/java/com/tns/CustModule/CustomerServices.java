package com.tns.CustModule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServices {
@Autowired
public CustomerRepository repository;
	 
public List<Customer> listAll()  
{ 
    return repository.findAll(); 
}       
public void save(Customer cust)  
{ 
	repository.save(cust); 
}       
public Customer get(Integer id)  
{ 
    return ( repository.findById(id)).get();
}       
public void delete(Integer id)  
{ 
	repository.deleteById(id); 
} 
} 
 

