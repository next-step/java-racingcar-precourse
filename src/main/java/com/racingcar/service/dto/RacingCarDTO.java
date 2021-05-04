package com.racingcar.service.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@EqualsAndHashCode
@Getter
public class RacingCarDTO implements Comparable<RacingCarDTO>{
	@NonNull
	private final String name;

	@Override
	public int compareTo(RacingCarDTO o) {
		return name.compareTo(o.name);
	}
}
