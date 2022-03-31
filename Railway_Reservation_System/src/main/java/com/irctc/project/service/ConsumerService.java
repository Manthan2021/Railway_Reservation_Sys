package com.irctc.project.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.irctc.project.model.Consumer;
import com.irctc.project.repository.ConsumerRepository;

@Service
@Transactional

public class ConsumerService {

	@Autowired
	public ConsumerRepository cRepo;
	
	public void saveConsumer(Consumer consumer) {
		
		cRepo.save(consumer);
	}
	
}
