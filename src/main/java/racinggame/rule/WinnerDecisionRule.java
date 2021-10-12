package racinggame.rule;

import racinggame.circuit.FinalRecord;

public interface WinnerDecisionRule {
	WinnerNames judgeWinner(FinalRecord finalRecord);
}