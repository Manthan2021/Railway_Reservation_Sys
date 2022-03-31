package com.irctc.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.project.exception.ResourceNotFoundException;
import com.irctc.project.model.Consumer;
import com.irctc.project.repository.ConsumerRepository;

@RestController
public class ConsumerController {

	@Autowired
	private ConsumerRepository cRepo;
	
	
	@PostMapping("/consumer")
	public Consumer saveConsumer(@Validated @RequestBody Consumer consumer) {
		
		Consumer c=new Consumer();
		c.setEmail(consumer.getEmail());
		c.setFname(consumer.getFname());
		c.setLname(consumer.getLname());
		c.setMobilenumber(consumer.getLname());
		c.setPassword(consumer.getPassword());
		
		cRepo.save(c);
		return consumer;
	}
	
	@GetMapping("/getConsumer/{email}")
    public Consumer getConsumer(@PathVariable String email) {
		
		Consumer c=cRepo.findByEmail(email);
		return c;
	}
	
	@PostMapping("/consumerlogin") 
	public Boolean loginConsumer(@Validated @RequestBody Consumer consumer) throws ResourceNotFoundException 
	{
		Boolean a=false;
		String email=consumer.getEmail();
		String password=consumer.getPassword();
		
		Consumer c= cRepo.findItByEmail(email).orElseThrow(()->
		new ResourceNotFoundException("user not exist " + email));
		
		if(email.equals(c.getEmail()) && password.equals(c.getPassword()))
		{
			a=true;
		}
		return a;
	}
	
	
	
}
