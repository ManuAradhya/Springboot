package com.tns.CustModule;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController
{
@Autowired
private CustomerServices service;

@GetMapping("/customers")
public List<Customer> list()
{
	return service.listAll();	
}
@GetMapping("/customers/{id}")
public ResponseEntity<Customer> get(@PathVariable int id)
{
	try {
		Customer cust = service.get(id);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
	catch (NoSuchElementException e)
	{
		return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	}
}
// RESTful API method for Create operation 
@PostMapping("/customers") 
public void add(@RequestBody Customer cust)  
{ 
    service.save(cust); 
} 
  
// RESTful API method for Update operation 
@PutMapping("/customers/{id}") 
public ResponseEntity<?> update(@RequestBody Customer cust, @PathVariable Integer id)  
{         try  
    { 
        Customer existCustomer = service.get(id);             
        service.save(cust); 
        return new ResponseEntity<>(HttpStatus.OK); 
    }  
    catch (NoSuchElementException e)  
    { 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND); 
    }       
} 
// RESTful API method for Delete operation    
@DeleteMapping("/customers/{id}") 
public void delete(@PathVariable Integer id)  
{ 
    service.delete(id); 
} 
} 



