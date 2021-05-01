package racing.vo;

public class Rule {

    private Round round;

    public Rule(int round) {
        this.round = new Round(round);
    }

    public Round getRound(){
        return this.round;
    }

}
