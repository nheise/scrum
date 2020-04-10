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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bug extends AbstractPersistable<Long> {

	enum Priority {
		CRITICAL, MAJOR, MINOR
	}

	enum Status {
		NEW, VERIFIED, RESOLVED
	}

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private Date creationDate = new Date();

	@Enumerated(EnumType.STRING)
	@Column
	private Priority priority = Priority.MINOR;

	@Enumerated(EnumType.STRING)
	@Column
	private Status status = Status.NEW;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_assignee")
	private Developer assignee;

}
