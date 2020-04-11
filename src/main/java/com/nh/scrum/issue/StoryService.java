package com.nh.scrum.issue;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nh.scrum.repository.InMemoryRepository;

@Service
public class StoryService {

	private InMemoryRepository<Story> storyRepository = new InMemoryRepository<>();

	public Story save(Story story) {
		return storyRepository.save(story);
	}

	public Optional<Story> findById(Long id) {
		return storyRepository.findById(id);
	}

	public void remove(Story story) {
		storyRepository.delete(story);
	}

	public List<Story> findAll() {
		List<Story> all = new ArrayList<>();
		storyRepository.findAll().forEach(all::add);
		return all;
	}

	public List<Story> findAllEstimated() {
		return findAll().stream().filter(story -> story.getStatus() == Story.Status.ESTIMATED).collect(toList());
	}

}
