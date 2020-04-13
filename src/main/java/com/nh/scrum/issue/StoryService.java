package com.nh.scrum.issue;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.nh.scrum.repository.InMemoryRepository;

@Service
public class StoryService {

	@Autowired
	private InMemoryRepository<Story> storyRepository;

	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Story save(Story story) {
		Story savedStory = storyRepository.save(story);

		applicationEventPublisher.publishEvent(new StoriesChangedEvent(savedStory));
		return savedStory;
	}

	public void remove(Story story) {
		storyRepository.delete(story);
		applicationEventPublisher.publishEvent(new StoriesChangedEvent(story));
	}

	public Optional<Story> findById(Long id) {
		return storyRepository.findById(id);
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
