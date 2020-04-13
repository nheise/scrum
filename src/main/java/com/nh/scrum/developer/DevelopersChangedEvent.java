package com.nh.scrum.developer;

import org.springframework.context.ApplicationEvent;

public class DevelopersChangedEvent extends ApplicationEvent {

	private static final long serialVersionUID = 2495768297769404374L;

	public DevelopersChangedEvent(Object source) {
		super(source);
	}

}
