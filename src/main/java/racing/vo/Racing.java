package racing.vo;

import java.util.List;

public class Racing {

    private Rule rule;
    private Reception reception;

    public Racing(Rule rule,Reception reception){
        this.rule = rule;
        this.reception = reception;
    }

    public int gameRound() {
        return rule.getRound().getValue();
    }

    public List<Car> gamePlayers () {
        return reception.getParticipants();
    }
}
