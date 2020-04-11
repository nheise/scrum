package com.nh.scrum.developer;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class DeveloperRepositoryInMem {

	private Long nextId = 0L;

	private Map<Long, Developer> developers = new HashMap<>();

	public Developer save(Developer developer) {
		if (Objects.isNull(developer.getId())) {
			developer.setId(getNextId());
		}
		developers.put(developer.getId(), developer);
		return developer;
	}

	private Long getNextId() {
		Long id = nextId;
		nextId++;
		return id;
	}

	public Optional<Developer> findById(Long id) {
		Developer developer = developers.get(id);
		return Optional.ofNullable(developer);
	}

	public void delete(Developer developer) {
		developers.remove(developer.getId());
	}

	public Iterable<Developer> findAll() {
		return developers.values();
	}

}
