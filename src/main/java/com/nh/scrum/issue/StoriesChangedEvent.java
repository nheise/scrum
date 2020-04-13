package com.nh.scrum.issue;

import org.springframework.context.ApplicationEvent;

public class StoriesChangedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2495768297769404374L;

	public StoriesChangedEvent(Object source) {
		super(source);
	}

}
