package com.nh.scrum.schedule;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

public class ScheduleBuilder {

	private List<Developer> developers;

	private List<WeekScheduleBuilder> weekScheduleBuilders = new ArrayList<>();

	private WeekScheduleBuilder actualWeekScheduleBuilder;

	public ScheduleBuilder(List<Developer> developers) {
		this.developers = developers;
		introduceNewWeekScheduleBuilder();
	}

	public Schedule build() {
		return new Schedule(buildWeekSchedules());
	}

	public ScheduleBuilder addStories(List<Story> stories) {
		stories.forEach(story -> addStory(story));
		return this;
	}

	public ScheduleBuilder addStory(Story story) {
		try {
			actualWeekScheduleBuilder.tryToAddStory(story);
		} catch (UnableToAddStoryException e) {
			introduceNewWeekScheduleBuilder();
			addStory(story);
		}
		return this;
	}

	private void introduceNewWeekScheduleBuilder() {
		actualWeekScheduleBuilder = WeekScheduleBuilder.create(developers);
		weekScheduleBuilders.add(actualWeekScheduleBuilder);
	}

	private List<WeekSchedule> buildWeekSchedules() {
		return weekScheduleBuilders.stream().map(WeekScheduleBuilder::build).collect(toList());
	}

	public static ScheduleBuilder create(List<Developer> developers) {
		return new ScheduleBuilder(developers);
	}

}
