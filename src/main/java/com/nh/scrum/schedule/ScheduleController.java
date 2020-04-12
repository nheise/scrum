package com.nh.scrum.schedule;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/schedules")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<Schedule> create(@RequestBody Schedule schedule) {
		return ResponseEntity.ok(scheduleService.save(schedule));
	}

	@PutMapping("{id}")
	public ResponseEntity<Schedule> update(@PathVariable("id") Long id, @RequestBody Schedule schedule) {
		return ResponseEntity.ok(scheduleService.save(schedule));
	}

	@GetMapping
	public ResponseEntity<List<Schedule>> list() {
		return ResponseEntity.ok(scheduleService.findAll());
	}

	@GetMapping("{id}")
	public ResponseEntity<Schedule> get() {
		return ResponseEntity.ok(scheduleService.findAll().get(0));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Schedule> delete(@PathVariable("id") Long id) {
		Optional<Schedule> schedule = scheduleService.findById(id);
		if (schedule.isPresent()) {
			scheduleService.remove(schedule.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
