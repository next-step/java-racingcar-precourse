package racinggame.domain;

import nextstep.utils.Randoms;

public class Car {

    private String name;

    private int currentStep;

    public Car(String name){
        this.name = name;
        this.currentStep = 0;
    }

    public String  getName(){
        return name;
    }

    public int getCurrentStep(){
        return currentStep;
    }

    /**
     * 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     */
    public void moveStep(){
        if (Randoms.pickNumberInRange(0,9) >= 4){
//            System.out.println("this.currentStep += 1");
            this.currentStep += 1;
        }
    }

    public void printCurrentStep(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < currentStep; i++){
            sb.append("-");
        }
        System.out.println(name + " : " + sb);
    }

}
