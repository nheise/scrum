package com.nh.scrum.schedule;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.developer.DeveloperService;
import com.nh.scrum.developer.DevelopersChangedEvent;
import com.nh.scrum.issue.StoriesChangedEvent;
import com.nh.scrum.issue.Story;
import com.nh.scrum.issue.StoryService;
import com.nh.scrum.repository.InMemoryRepository;

@Service
public class ScheduleService {

	@Autowired
	private DeveloperService developerService;

	@Autowired
	private StoryService storyService;

	@Autowired
	private InMemoryRepository<Schedule> scheduleRepository;

	public Schedule save(Schedule schedule) {
		return scheduleRepository.save(schedule);
	}

	public Optional<Schedule> findById(Long id) {
		return scheduleRepository.findById(id);
	}

	public void remove(Schedule schedule) {
		scheduleRepository.delete(schedule);
	}

	public List<Schedule> findAll() {
		List<Schedule> all = new ArrayList<>();
		scheduleRepository.findAll().forEach(all::add);
		return all;
	}

	@EventListener(classes = { DevelopersChangedEvent.class, StoriesChangedEvent.class })
	public void reSchedule() {
		List<Story> allEstimatedStories = findAllEstimatedStoriesAndSortByStoryPointsDesc();
		List<Developer> developers = developerService.findAll();

		ScheduleBuilder builder = ScheduleBuilder.create(developers).addStories(allEstimatedStories);
		Schedule schedule = builder.build();
		schedule.setId(0L);

		scheduleRepository.save(schedule);
	}

	private List<Story> findAllEstimatedStoriesAndSortByStoryPointsDesc() {
		return storyService.findAllEstimated().stream()
				.sorted(Comparator.comparingInt(Story::getStoryPoints).reversed()).collect(toList());
	}

}
