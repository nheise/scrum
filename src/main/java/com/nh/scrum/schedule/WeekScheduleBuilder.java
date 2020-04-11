package com.nh.scrum.schedule;

import static java.util.stream.Collectors.toList;

import java.util.List;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

public class WeekScheduleBuilder {

	private List<DeveloperScheduleBuilder> developerScheduleBuilders;

	public WeekScheduleBuilder(List<Developer> developers) {
		developerScheduleBuilders = mapDeveloperIntoBuilders(developers);
	}

	private List<DeveloperScheduleBuilder> mapDeveloperIntoBuilders(List<Developer> developers) {
		return developers.stream().map(DeveloperScheduleBuilder::create).collect(toList());
	}

	public WeekSchedule build() {
		return new WeekSchedule(buildDeveloperSchedules());
	}

	public WeekScheduleBuilder tryToAddStory(Story newStory) throws UnableToAddStoryException {

		for (DeveloperScheduleBuilder developerScheduleBuilder : developerScheduleBuilders) {
			try {
				developerScheduleBuilder.tryToAddStory(newStory);
				return this;
			} catch (UnableToAddStoryException e) {

			}
		}
		throw new UnableToAddStoryException();
	}

	private List<DeveloperSchedule> buildDeveloperSchedules() {
		return developerScheduleBuilders.stream().map(DeveloperScheduleBuilder::build).collect(toList());
	}

	public static WeekScheduleBuilder create(List<Developer> developers) {
		return new WeekScheduleBuilder(developers);
	}
}
