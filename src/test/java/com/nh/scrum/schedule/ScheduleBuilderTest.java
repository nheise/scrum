package com.nh.scrum.schedule;

import static com.nh.scrum.initializer.SampleDataInitializer.createDevelopers;
import static com.nh.scrum.initializer.SampleDataInitializer.createStoriesWithPoints;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

class ScheduleBuilderTest {

	private List<Developer> developers = createDevelopers("tester1", "tester2");

	@Test
	void smallStoriesShouldBeAdded() {
		List<Story> stories = createStoriesWithPoints(10, 1, 1);

		ScheduleBuilder builder = ScheduleBuilder.create(developers).addStories(stories);

		Schedule schedule = builder.build();

		List<WeekSchedule> weekSchedules = schedule.getWeekSchedules();

		assertThat(weekSchedules.size(), is(1));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().size(), is(2));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().get(0).getStories().size(), is(1));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().get(1).getStories().size(), is(2));
	}

	@Test
	void tooMuchStoriesShouldBuildTwoWeeks() {

		List<Story> stories = createStoriesWithPoints(10, 10, 1);

		ScheduleBuilder builder = ScheduleBuilder.create(developers).addStories(stories);

		Schedule schedule = builder.build();

		List<WeekSchedule> weekSchedules = schedule.getWeekSchedules();

		assertThat(weekSchedules.size(), is(2));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().size(), is(2));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().get(0).getStories().size(), is(1));
		assertThat(weekSchedules.get(0).getDeveloperSchedules().get(1).getStories().size(), is(1));
		assertThat(weekSchedules.get(1).getDeveloperSchedules().size(), is(2));
		assertThat(weekSchedules.get(1).getDeveloperSchedules().get(0).getStories().size(), is(1));
		assertThat(weekSchedules.get(1).getDeveloperSchedules().get(1).getStories().size(), is(0));
	}

}
