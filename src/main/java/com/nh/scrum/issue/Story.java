package com.nh.scrum.issue;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.nh.scrum.developer.Developer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Story extends AbstractPersistable<Long> {

	enum Status {
		NEW, ESTIMATED, COMPLETED
	}

	@Column
	private String title = "";

	@Column
	private String description = "";

	@Column
	private Date creationDate = new Date();

	@Enumerated(EnumType.STRING)
	@Column
	private Status status = Status.NEW;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_assignee")
	private Developer assignee;

	@Column
	@NonNull
	private Integer storyPoints;

}
