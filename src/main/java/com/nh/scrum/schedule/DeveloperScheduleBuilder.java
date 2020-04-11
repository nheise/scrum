package com.nh.scrum.schedule;

import java.util.ArrayList;
import java.util.List;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeveloperScheduleBuilder {

	private static final int MAX_STORY_POINTS_PER_DEVELOPER = 10;

	@NonNull
	private Developer developer;

	private List<Story> stories = new ArrayList<>();

	public DeveloperScheduleBuilder tryToAddStory(Story newStory) throws UnableToAddStoryException {
		int newStoryPointMax = countStoryPoints() + newStory.getStoryPoints();

		if (newStoryPointMax > MAX_STORY_POINTS_PER_DEVELOPER) {
			throw new UnableToAddStoryException();
		}
		stories.add(newStory);
		return this;
	}

	public DeveloperSchedule build() {
		return new DeveloperSchedule(developer, stories);
	}

	private int countStoryPoints() {
		return stories.stream().mapToInt(Story::getStoryPoints).sum();
	}

	public static DeveloperScheduleBuilder create(Developer developer) {
		return new DeveloperScheduleBuilder(developer);
	}

}
