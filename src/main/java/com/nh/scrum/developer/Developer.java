package com.nh.scrum.developer;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@RequiredArgsConstructor
@NoArgsConstructor
public class Developer {

	private Long id = null;

	@NonNull
	private String name;

}
