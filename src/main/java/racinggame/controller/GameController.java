package racinggame.controller;

import racinggame.domain.Count;
import racinggame.domain.Game;
import racinggame.dto.ResponseDto;
import racinggame.dto.ResultDto;

public class GameController {
	private Game game;

	private GameController() {
	}

	public static GameController getInstance() {
		return new GameController();
	}

	public ResponseDto create(String input) {
		try {
			game = Game.ready(input.split(","));
			return ResponseDto.ok("");
		} catch (IllegalArgumentException e) {
			return ResponseDto.error(e.getMessage());
		}
	}

	public ResponseDto run(String input) {
		try {
			ResultDto result = game.start(Count.of(parseInt(input)));
			return ResponseDto.ok(result.getMessage());
		} catch (IllegalArgumentException e) {
			return ResponseDto.error(e.getMessage());
		}
	}

	private int parseInt(String input) throws IllegalArgumentException {
		try {
			return Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력 가능합니다.");
		}
	}
}
