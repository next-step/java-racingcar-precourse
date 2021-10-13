package racinggame.machine;

import racinggame.circuit.FinalRecord;
import racinggame.machine.winnerrule.WinnerNames;

public interface WinnerDecisionRule {
	WinnerNames judgeWinner(FinalRecord finalRecord);
}