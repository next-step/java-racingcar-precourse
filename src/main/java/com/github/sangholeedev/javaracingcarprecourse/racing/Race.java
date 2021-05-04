package com.github.sangholeedev.javaracingcarprecourse.racing;

import com.github.sangholeedev.javaracingcarprecourse.player.Player;

public class Race {
	private final Player player;
	private final RaceCount raceCount;

	public Race(final Player player, final RaceCount raceCount) {
		this.player = player;
		this.raceCount = raceCount;
	}
}
