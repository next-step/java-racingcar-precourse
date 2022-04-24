package racingcar.mvc.controller;

public class UserInputs {

    public static boolean isValidLength(String playerName) {
        if (5 < playerName.length()) return false;
        else return true;
    }

    private String[] playerNames;
    private Integer numberOfRound;
    private Integer trialNumber = 0;


    public boolean isAllValid() {
        if (this.playerNames == null) return false;
        if (this.numberOfRound == null) return false;

        if (this.playerNames.length <= 0) return false;

        return true;
    }

    public void increaseOneTrial() {
        this.trialNumber = this.trialNumber + 1;
    }

    public Integer getTrialNumber(){
        return this.trialNumber;
    }


    public String[] getPlayerNames() {
        return this.playerNames;
    }


    public void setPlayerNames(String[] playerNames) {
        for (String name : playerNames) {
            if (!isValidLength(name)) throw new IllegalArgumentException("이름은 5글자 이하만 가능합니다.");
        }
        this.playerNames = playerNames;
    }

    public Integer getNumberOfRound() {
        return this.numberOfRound;
    }

    public void setNumberOfRound(Integer number) {
        this.numberOfRound = number;
    }

}
