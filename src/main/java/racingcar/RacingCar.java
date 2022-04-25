package racingcar;



import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class RacingCar implements Comparable<RacingCar> {
    private String racingCarName;
    private int forwardCount;
    public RacingCar(String racingGameNameInput) {
        this.racingCarName = racingGameNameInput;
    }

    public void race() {
        String dash = "";
        int random = pickNumberInRange(0, 9);

        if(random >=4){
            forwardCount++;
        }

        for (int i = 0; i < forwardCount; i++) {
            dash += "-";
        }

        System.out.println(this.racingCarName + " : " + dash);
    }

    public String getRacingCarName() {
        return racingCarName;
    }

    public int getForwardCount() {
        return forwardCount;
    }


    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.getForwardCount(),this.getForwardCount());

    }
}
