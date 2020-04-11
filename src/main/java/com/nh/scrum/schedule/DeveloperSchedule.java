package com.nh.scrum.schedule;

import java.util.ArrayList;
import java.util.List;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperSchedule {

	private Developer developer;

	private List<Story> stories = new ArrayList<>();
}
