package com.nh.scrum.schedule;

import java.util.List;

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
public class Schedule implements HasLongId {

	private Long id = null;

	@NonNull
	private List<WeekSchedule> weekSchedules;
}
