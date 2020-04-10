package com.nh.scrum.schedule;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import com.nh.scrum.developer.Developer;
import com.nh.scrum.issue.Story;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DeveloperSchedule extends AbstractPersistable<Long> {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fk_developer")
	private Developer developer;

	@OneToMany
	private List<Story> stories = new ArrayList<>();
}
