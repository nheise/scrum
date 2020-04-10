package com.nh.scrum.schedule;

import java.util.Collections;
import java.util.List;

import com.nh.scrum.developer.Developer;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WeekScheduleBuilder {

	private static final int MAX_STORY_POINTS_PER_DEVELOPER_A_WEEK = 10;

	private List<Developer> developers = Collections.emptyList();

	private int maxStoryPoints() {
		return developers.size() * MAX_STORY_POINTS_PER_DEVELOPER_A_WEEK;
	}

}
