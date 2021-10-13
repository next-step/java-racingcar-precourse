package racinggame.rule.winnerrules;

import racinggame.circuit.FinalRecord;

public interface WinnerDecisionRule {
	WinnerNames judgeWinner(FinalRecord finalRecord);
}