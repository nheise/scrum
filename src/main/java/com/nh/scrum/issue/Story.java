package com.nh.scrum.issue;

import java.util.Date;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.repository.HasLongId;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@NoArgsConstructor
public class Story implements HasLongId {

	private Long id = null;

	public enum Status {
		NEW, ESTIMATED, COMPLETED
	}

	private String title = "";

	private String description = "";

	private Date creationDate = new Date();

	private Status status = Status.NEW;

	private Developer assignee;

	@NonNull
	private Integer storyPoints;

}
