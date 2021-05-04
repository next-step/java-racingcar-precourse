package com.racingcar.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.RacingCar;
import com.racingcar.domain.RacingCarGroup;
import com.racingcar.service.dto.RacingCarDTO;

public class RefereeServiceImpl implements RefereeService {
	@Override
	public List<RacingCarDTO> judge(RacingCarGroup carGroup) {
		if (carGroup.getRacingCarList().isEmpty()) {
			throw new RacingCarException(Messages.JUDGE_WINNER_EXCEPTION_MESSAGE);
		}
		return getWinners(carGroup.getRacingCarList());
	}

	private List<RacingCarDTO> getWinners(List<RacingCar> cars) {
		SortedMap<Integer, List<RacingCarDTO>> carMap = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));

		for (RacingCar car : cars) {
			carMap.computeIfAbsent(car.getMoveCount(), ArrayList::new).add(new RacingCarDTO(car.getName()));
		}

		List<RacingCarDTO> winners = carMap.get(carMap.firstKey());
		Collections.sort(winners);

		return winners;
	}
}
