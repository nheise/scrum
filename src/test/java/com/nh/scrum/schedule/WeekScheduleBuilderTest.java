package com.nh.scrum.schedule;

import static com.nh.scrum.initializer.SampleDataInitializer.createDevelopers;
import static com.nh.scrum.initializer.SampleDataInitializer.createStoriesWithPoints;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

class WeekScheduleBuilderTest {

	private List<Developer> developers = createDevelopers("tester1", "tester2");

	@Test
	void smallStoriesShouldBeAdded() {
		List<Story> stories = createStoriesWithPoints(10, 1, 1);

		WeekScheduleBuilder builder = WeekScheduleBuilder.create(developers);
		stories.forEach(builder::tryToAddStory);

		WeekSchedule schedule = builder.build();

		assertThat(schedule.getDeveloperSchedules().size(), is(2));
		assertThat(schedule.getDeveloperSchedules().get(0).getStories().size(), is(1));
		assertThat(schedule.getDeveloperSchedules().get(1).getStories().size(), is(2));
	}

	@Test
	void tooMuchStoriesMustThrow() {
		List<Story> stories = createStoriesWithPoints(10, 10, 1);

		WeekScheduleBuilder builder = WeekScheduleBuilder.create(developers);

		assertThrows(UnableToAddStoryException.class, () -> {
			stories.forEach(builder::tryToAddStory);
		});

		WeekSchedule schedule = builder.build();

		assertThat(schedule.getDeveloperSchedules().size(), is(2));
		assertThat(schedule.getDeveloperSchedules().get(0).getStories().size(), is(1));
		assertThat(schedule.getDeveloperSchedules().get(1).getStories().size(), is(1));
	}

}
