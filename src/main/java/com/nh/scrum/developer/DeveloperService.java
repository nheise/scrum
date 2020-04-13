package com.nh.scrum.developer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.nh.scrum.repository.InMemoryRepository;

@Service
public class DeveloperService {

	@Autowired
	private InMemoryRepository<Developer> developerRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Developer save(Developer developer) {
		Developer savedDeveloper = developerRepository.save(developer);

		applicationEventPublisher.publishEvent(new DevelopersChangedEvent(savedDeveloper));
		return savedDeveloper;
	}

	public void remove(Developer developer) {
		developerRepository.delete(developer);
		applicationEventPublisher.publishEvent(new DevelopersChangedEvent(developer));
	}

	public Optional<Developer> findById(Long id) {
		return developerRepository.findById(id);
	}

	public List<Developer> findAll() {
		List<Developer> all = new ArrayList<>();
		developerRepository.findAll().forEach(all::add);
		return all;
	}

}
