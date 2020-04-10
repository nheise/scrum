package com.nh.scrum.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

	@Autowired
	private DeveloperRepository developerRepository;

	public Developer save(Developer developer) {
		return developerRepository.save(developer);
	}

	public Optional<Developer> findById(Long id) {
		return developerRepository.findById(id);
	}

	public void remove(Developer developer) {
		developerRepository.delete(developer);
	}

	public List<Developer> findAll() {
		List<Developer> all = new ArrayList<>();
		developerRepository.findAll().forEach(all::add);
		return all;
	}

}
