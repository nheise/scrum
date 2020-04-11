package com.nh.scrum.initializer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.developer.DeveloperService;

@Component
public class SampleDataInitializer {

	@Autowired
	private DeveloperService developerService;

	@EventListener(ApplicationReadyEvent.class)
	public void initialize() {
		developerService.save(new Developer(null, "John"));
		developerService.save(new Developer(null, "Frank"));
	}

}
