package com.irctc.project.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.irctc.project.model.Schedule;
import com.irctc.project.model.Station;
import com.irctc.project.model.StationRequest;
import com.irctc.project.model.Train;
import com.irctc.project.repository.TrainRepository;
import com.irctc.project.service.StationService;


@RestController
public class TrainController {
	
	
	
	@Autowired
	private TrainRepository tRepo;
	
	@Autowired 
	private StationService sService;
	
	
	
	
	@PostMapping("/addStation")
	public Station addstation(@RequestBody StationRequest station) {
		
		return sService.addStationWithTrains(station);
		
	}
	
	@PostMapping("/addSchedule")
	public Schedule addschedule(@RequestBody Schedule s) {
		
		return sService.addSchedule(s);
	}
	
}
