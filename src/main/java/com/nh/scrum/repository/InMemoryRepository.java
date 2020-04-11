package com.nh.scrum.repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class InMemoryRepository<T extends HasLongId> {

	private Long nextId = 0L;

	private Map<Long, T> items = new HashMap<>();

	public T save(T item) {
		if (Objects.isNull(item.getId())) {
			item.setId(getNextId());
		}
		items.put(item.getId(), item);
		return item;
	}

	private Long getNextId() {
		Long id = nextId;
		nextId++;
		return id;
	}

	public Optional<T> findById(Long id) {
		T item = items.get(id);
		return Optional.ofNullable(item);
	}

	public void delete(T item) {
		items.remove(item.getId());
	}

	public Iterable<T> findAll() {
		return items.values();
	}

}
