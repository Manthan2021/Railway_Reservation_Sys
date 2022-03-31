package com.irctc.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.irctc.project.model.Station;

public interface StationRepository extends JpaRepository<Station,Long> {

	public Station findById(long id);
}
