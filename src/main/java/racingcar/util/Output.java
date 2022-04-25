package racingcar.util;

import racingcar.domain.Driver;
import racingcar.domain.Match;

public class Output {
    public static void result(Match match){
        System.out.println("최종 우승자: " + match.result());
    }

    public static void roundResult(Match match){
        for(Driver driver : match.getDrivers().getDrivers()){
            System.out.println(driver.getName() + " : " + driver.getDistance());
        }

        System.out.println("");
    }
}
