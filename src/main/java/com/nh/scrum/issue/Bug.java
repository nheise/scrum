package com.nh.scrum.issue;

import java.util.Date;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.repository.HasLongId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Bug implements HasLongId {

	private Long id = null;

	enum Priority {
		CRITICAL, MAJOR, MINOR
	}

	enum Status {
		NEW, VERIFIED, RESOLVED
	}

	private String title;

	private String description;

	private Date creationDate = new Date();

	private Priority priority = Priority.MINOR;

	private Status status = Status.NEW;

	private Developer assignee;

}
