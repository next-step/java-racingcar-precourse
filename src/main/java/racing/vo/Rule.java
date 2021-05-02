package racing.vo;

public class Rule {

    private Round round;

    public Rule(String round) {
        this.round = new Round(round);
    }

    public Round getRound(){
        return this.round;
    }

}
