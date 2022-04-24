package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car_Name_Position {
    private static final int min_length_name = 1;
    public static final int max_length_name = 5;
    public static final int min_move = 4;
    public static final int min_range_move = 0;
    public static final int max_range_move = 9;
    public static final String road = "-";
    public static final String name_length_info = "[ERROR] The name of car should be from 1 character to 5 characters.";

    private final String name;
    private int position = 0;


    private void validName(String name) {
        if (name.length() < min_length_name || name.length() > max_length_name) {
            System.out.println(name_length_info);
            throw new IllegalArgumentException();
        }
    }

    public Car_Name_Position(String name){
        validName(name);
        this.name = name;
    }

    private boolean movable() {
        return Randoms.pickNumberInRange(min_range_move, max_range_move) >= min_move;
    }

    public void move() {
        if (movable()) {
            position += 1;
        }
    }

    private String getRoad() {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < position; i++) {
            stringBuffer.append(road);
        }
        return stringBuffer.toString();
    }

    public boolean isSamePosition(int maxPosition) {
        return position == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " : " + getRoad();
    }



}
