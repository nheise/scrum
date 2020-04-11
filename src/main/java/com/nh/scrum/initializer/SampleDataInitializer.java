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
import com.nh.scrum.issue.StoryService;
import com.nh.scrum.schedule.ScheduleService;

@Component
public class SampleDataInitializer {

	@Autowired
	private DeveloperService developerService;

	@Autowired
	private StoryService storyService;

	@Autowired
	private ScheduleService scheduleService;

	@EventListener(ApplicationReadyEvent.class)
	public void initialize() {
		createDevelopers("John", "Frank").stream().map(developerService::save).collect(toList());

		Story story = createStory("story 1", "story 1", 1);
		storyService.save(story);
		story = createStory("story 2", "story 2", 2);
		storyService.save(story);

		story = createStory("story 3", "story 3", 5);
		story.setStatus(Story.Status.ESTIMATED);
		storyService.save(story);
		story = createStory("story 4", "story 4", 10);
		story.setStatus(Story.Status.ESTIMATED);
		storyService.save(story);

		scheduleService.reSchedule();

	}

	private Story createStory(String title, String description, int storyPoints) {
		Story story = new Story(storyPoints);
		story.setTitle(title);
		story.setDescription(description);
		return story;
	}

	public static List<Story> createStoriesWithPoints(Integer... storyPoints) {
		return asList(storyPoints).stream().map(points -> new Story(points)).collect(toList());
	}

	public static List<Developer> createDevelopers(String... names) {
		return asList(names).stream().map(name -> new Developer(name)).collect(toList());
	}

}
