package com.nh.scrum.issue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nh.scrum.repository.InMemoryRepository;

@Service
public class BugService {

	private InMemoryRepository<Bug> bugRepository = new InMemoryRepository<>();

	public Bug save(Bug bug) {
		return bugRepository.save(bug);
	}

	public Optional<Bug> findById(Long id) {
		return bugRepository.findById(id);
	}

	public void remove(Bug bug) {
		bugRepository.delete(bug);
	}

	public List<Bug> findAll() {
		List<Bug> all = new ArrayList<>();
		bugRepository.findAll().forEach(all::add);
		return all;
	}

}
