package com.nh.scrum.initializer;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.developer.DeveloperService;
import com.nh.scrum.issue.Story;

@Component
public class SampleDataInitializer {

	@Autowired
	private DeveloperService developerService;

	@EventListener(ApplicationReadyEvent.class)
	public void initialize() {
		createDevelopers("John", "Frank").stream().map(developerService::save).collect(toList());
	}

	public static List<Story> createStoriesWithPoints(Integer... storyPoints) {
		return asList(storyPoints).stream().map(points -> new Story(points)).collect(toList());
	}

	public static List<Developer> createDevelopers(String... names) {
		return asList(names).stream().map(name -> new Developer(name)).collect(toList());
	}

}
