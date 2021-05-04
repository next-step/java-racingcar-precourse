package com.racingcar.service;

import java.util.List;

import com.racingcar.domain.RacingCarGroup;
import com.racingcar.service.dto.RacingCarDTO;

public interface RefereeService {

	List<RacingCarDTO> judge(RacingCarGroup carGroup);
}
