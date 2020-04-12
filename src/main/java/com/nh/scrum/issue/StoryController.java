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
@RequestMapping("/stories")
public class StoryController {

	@Autowired
	private StoryService storyService;

	@PostMapping
	public ResponseEntity<Story> create(@RequestBody Story story) {
		return ResponseEntity.ok(storyService.save(story));
	}

	@PutMapping("{id}")
	public ResponseEntity<Story> update(@PathVariable("id") Long id, @RequestBody Story story) {
		return ResponseEntity.ok(storyService.save(story));
	}

	@GetMapping
	public ResponseEntity<List<Story>> list() {
		return ResponseEntity.ok(storyService.findAll());
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Story> delete(@PathVariable("id") Long id) {
		Optional<Story> story = storyService.findById(id);
		if (story.isPresent()) {
			storyService.remove(story.get());
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
