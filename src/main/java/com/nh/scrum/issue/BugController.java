package com.nh.scrum.issue;

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
@RequestMapping("/bugs")
public class BugController {

	@Autowired
	private BugService bugService;

	@PostMapping
	public ResponseEntity<Bug> create(@RequestBody Bug bug) {
		return ResponseEntity.ok(bugService.save(bug));
	}

	@PutMapping("{id}")
	public ResponseEntity<Bug> update(@PathVariable("id") Long id, @RequestBody Bug bug) {
		return ResponseEntity.ok(bugService.save(bug));
	}

	@GetMapping
	public ResponseEntity<List<Bug>> list() {
		return ResponseEntity.ok(bugService.findAll());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Bug> delete(@PathVariable("id") Long id) {
		Optional<Bug> bug = bugService.findById(id);
		if (bug.isPresent()) {
			bugService.remove(bug.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
