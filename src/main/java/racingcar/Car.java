package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import primitiveWrapperClass.Distance;
import primitiveWrapperClass.Name;
import primitiveWrapperClass.RandomNumber;

public class Car {
    private Name     name;
    private Distance distance;

    public Car( String name, String distance ) {
        this.name = new Name( name );
        this.distance = new Distance( distance );
    }

    public void goAhead(){
        RandomNumber randomNumber = new RandomNumber( Randoms.pickNumberInRange(0, 9) );
        if(randomNumber.isGreaterThanEqualFour()){
            distance.carMoved();
        }
    }

    public String myName(){
        return name.showName();
    }

    public String myTotalDistance(){
        return name.showName() + " : " + distance.totalDistance();
    }

    public int maxMoved(){
        return distance.totalDistance().length();
    }
}
