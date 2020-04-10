package com.nh.scrum.schedule;

import java.util.List;

import com.nh.scrum.issue.Story;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ScheduleBuilder {

	private List<Story> stories;

	private WeekScheduleBuilder weekScheduleBuilder;

	public Schedule build() {
		return null;
	}

}
