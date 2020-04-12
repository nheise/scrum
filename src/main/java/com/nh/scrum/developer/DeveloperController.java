package com.nh.scrum.developer;

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
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private DeveloperService developerService;

	@PostMapping
	public ResponseEntity<Developer> create(@RequestBody Developer developer) {
		return ResponseEntity.ok(developerService.save(developer));
	}

	@PutMapping("{id}")
	public ResponseEntity<Developer> update(@PathVariable("id") Long id, @RequestBody Developer developer) {
		return ResponseEntity.ok(developerService.save(developer));
	}

	@GetMapping
	public ResponseEntity<List<Developer>> list() {
		return ResponseEntity.ok(developerService.findAll());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Developer> delete(@PathVariable("id") Long id) {
		Optional<Developer> developer = developerService.findById(id);
		if (developer.isPresent()) {
			developerService.remove(developer.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
