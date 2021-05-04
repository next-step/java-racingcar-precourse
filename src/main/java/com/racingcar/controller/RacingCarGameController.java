package com.racingcar.controller;

import java.util.List;
import java.util.Objects;

import com.racingcar.common.exception.RacingCarException;
import com.racingcar.common.message.Messages;
import com.racingcar.domain.RacingCarGroup;
import com.racingcar.presentation.ConsoleDisplayImpl;
import com.racingcar.presentation.ConsoleInputImpl;
import com.racingcar.presentation.Display;
import com.racingcar.presentation.Input;
import com.racingcar.service.RacingCarMovingService;
import com.racingcar.service.RacingCarService;
import com.racingcar.service.RefereeService;
import com.racingcar.service.dto.RacingCarDTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(builderMethodName = "RacingCarGameControllerBuilder")
public class RacingCarGameController {
	private static final int INVALID_TRY_COUNT = -1;

	@NonNull
	@Builder.Default
	private Display display = new ConsoleDisplayImpl();
	@NonNull
	@Builder.Default
	private Input input = new ConsoleInputImpl();
	@NonNull
	private final RacingCarService racingCarService;
	@NonNull
	private final RacingCarMovingService racingCarMovingService;
	@NonNull
	private final RefereeService refereeService;

	public static RacingCarGameControllerBuilder builder(RacingCarService racingCarService,
		RacingCarMovingService racingCarMovingService, RefereeService refereeService) {

		if (Objects.isNull(racingCarService) || Objects.isNull(racingCarMovingService) || Objects.isNull(
			refereeService)) {
			throw new RacingCarException(Messages.REQUIRED_SERVICES_EXCEPTION_MESSAGE);
		}
		return RacingCarGameControllerBuilder().racingCarService(racingCarService)
			.racingCarMovingService(racingCarMovingService)
			.refereeService(refereeService);
	}

	public void play() {
		display.show(Messages.getMessageWithNewLine(Messages.INPUT_CAR_NAME_MESSAGE));
		RacingCarGroup carGroup = generateCarGroup();

		display.show(Messages.getMessageWithNewLine(Messages.INPUT_TRY_COUNT_MESSAGE));
		int tryCount = getTryCount();

		startRacing(carGroup, tryCount);

		judgeWinner(carGroup);
	}

	private RacingCarGroup generateCarGroup() {
		RacingCarGroup carGroup = null;

		while (Objects.isNull(carGroup)) {
			carGroup = generateCarGroup(input.getInput());
		}

		return carGroup;
	}

	private RacingCarGroup generateCarGroup(String input) {
		RacingCarGroup carGroup = null;
		try {
			carGroup = racingCarService.create(input);
		} catch (RacingCarException e) {
			display.show(Messages.getMessageWithNewLine(e.getMessage()));
		}
		return carGroup;
	}

	private int getTryCount() {
		int tryCount = INVALID_TRY_COUNT;
		while (tryCount == INVALID_TRY_COUNT) {
			tryCount = parseStringNum(input.getInput());
			displayInValidTryCount(tryCount);
		}
		return tryCount;
	}

	private int parseStringNum(String input) {
		int tryCount;

		try {
			tryCount = Integer.parseInt(input);
			tryCount = Math.max(tryCount, INVALID_TRY_COUNT);
		} catch (NumberFormatException e) {
			tryCount = INVALID_TRY_COUNT;
		}
		return tryCount;
	}

	private void displayInValidTryCount(int tryCount){
		if(tryCount == INVALID_TRY_COUNT){
			display.show(Messages.getMessageWithNewLine(Messages.INVALID_INPUT_MESSAGE));
		}
	}

	private void startRacing(RacingCarGroup carGroup, final int tryCount) {
		display.show(Messages.NEW_LINE);
		display.show(Messages.getMessageWithNewLine(Messages.RACING_RESULT_MESSAGE));

		if(tryCount == 0){
			display.show(Messages.getMessageWithNewLine(carGroup.toString()));
		}

		for (int count = 0; count < tryCount; count++) {
			racingCarMovingService.move(carGroup);
			display.show(Messages.getMessageWithNewLine(carGroup.toString()));
		}
	}

	private void judgeWinner(RacingCarGroup carGroup) {
		List<RacingCarDTO> winners = refereeService.judge(carGroup);
		displayWinner(winners);
	}

	private void displayWinner(List<RacingCarDTO> winners) {
		StringBuilder sb = new StringBuilder();

		for (RacingCarDTO winner : winners) {
			sb.append(winner.getName());
			sb.append(',');
		}
		sb.deleteCharAt(sb.lastIndexOf(","));
		sb.append(Messages.JUDGE_WINNER_MESSAGE);
		display.show(sb.toString());
	}

}
