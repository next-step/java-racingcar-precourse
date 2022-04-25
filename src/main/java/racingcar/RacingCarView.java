package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class RacingCarView {

    public int getMove() {
        return Integer.valueOf(Console.readLine());
    }

    public String[] getName() {
        String carNames = Console.readLine();
        String[] names = carNames.split(",");
        try {
            validateName(names);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getName();
        }
        return names;
    }

    public boolean validateName(String[] names) {
        for(int i=0;i<names.length;i++) {
            isNotNameEmpty(names[i]);
            isNotNameLengthOver(names[i]);
        }
        return true;
    }

    public boolean isNotNameEmpty(String name) {
        if(name==null || name.isEmpty()) {
            throw new IllegalArgumentException(Constants.NAME_EMPTY_MESSAGE);
        }
        return true;
    }

    public boolean isNotNameLengthOver(String name) {
        if(name.length()>5) {
            throw new IllegalArgumentException(Constants.NAME_LENGTH_OVER_MESSAGE);
        }
        return true;
    }

    public void printWinner(List<Car> cars) {
        StringBuilder winnerNames = new StringBuilder();
        int maxDistance=cars.get(0).getDistance();
        for(int i=0;i<cars.size();i++) {
            maxDistance = checkMaxDistance(cars.get(i), maxDistance, winnerNames);
        }
        if(winnerNames.charAt(winnerNames.length()-1)==',') {
            winnerNames.setLength(winnerNames.length()-1);
        }
        System.out.println("최종 우승자 : "+winnerNames);
    }

    public int checkMaxDistance(Car car, int maxDistance, StringBuilder winnerNames) {
        if(car.getDistance()>maxDistance) {
            maxDistance = car.getDistance();
            winnerNames.setLength(0);
            winnerNames.append(car.getName()+",");
        } else if(car.getDistance()==maxDistance) {
            winnerNames.append(car.getName()+",");
        }
        return maxDistance;
    }

    public void printDistance(Car car) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<car.getDistance();i++) {
            sb.append("-");
        }
        System.out.println(car.getName()+" : "+sb.toString());
    }

}
