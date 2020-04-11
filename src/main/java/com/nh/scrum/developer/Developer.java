package com.nh.scrum.developer;

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
public class Developer implements HasLongId {

	private Long id = null;

	@NonNull
	private String name;

}
