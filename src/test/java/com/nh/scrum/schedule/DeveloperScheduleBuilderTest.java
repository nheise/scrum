package com.nh.scrum.schedule;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

class DeveloperScheduleBuilderTest {

	private Developer developer = new Developer(1L, "tester");

	@Test
	void smallStoryShouldBeAdded() {
		Story story = createStoryWithPoints(1);

		DeveloperSchedule schedule = DeveloperScheduleBuilder.create(developer).tryToAddStory(story).build();

		assertThat(schedule.getDeveloper(), is(developer));
		assertThat(schedule.getStories().size(), is(1));
	}

	@Test
	void twoSmallStoriesShouldBeAdded() {
		Story story1 = createStoryWithPoints(1);
		Story story2 = createStoryWithPoints(1);

		DeveloperSchedule schedule = DeveloperScheduleBuilder.create(developer).tryToAddStory(story1)
				.tryToAddStory(story2).build();

		assertThat(schedule.getDeveloper(), is(developer));
		assertThat(schedule.getStories().size(), is(2));
	}

	@Test
	void bigStoryShouldBeAdded() {
		Story story = createStoryWithPoints(10);

		DeveloperSchedule schedule = DeveloperScheduleBuilder.create(developer).tryToAddStory(story).build();

		assertThat(schedule.getDeveloper(), is(developer));
		assertThat(schedule.getStories().size(), is(1));
	}

	@Test
	void tooBigStoryShouldThrow() {
		Story story = createStoryWithPoints(11);

		DeveloperScheduleBuilder builder = DeveloperScheduleBuilder.create(developer);

		assertThrows(UnableToAddStoryException.class, () -> {
			builder.tryToAddStory(story);
		});
		DeveloperSchedule schedule = builder.build();
		assertThat(schedule.getDeveloper(), is(developer));
		assertThat(schedule.getStories().size(), is(0));
	}

	@Test
	void twoStoriesOverTheLimitShouldThrow() {
		Story story1 = createStoryWithPoints(5);
		Story story2 = createStoryWithPoints(6);

		DeveloperScheduleBuilder builder = DeveloperScheduleBuilder.create(developer);
		builder.tryToAddStory(story1);

		assertThrows(UnableToAddStoryException.class, () -> {
			builder.tryToAddStory(story2);
		});
		DeveloperSchedule schedule = builder.build();
		assertThat(schedule.getDeveloper(), is(developer));
		assertThat(schedule.getStories().size(), is(1));
	}

	private Story createStoryWithPoints(int storyPoints) {
		Story story = new Story(storyPoints);
		return story;
	}

}
