package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    @DisplayName("문자열을 받아 N대의 자동차를 생성 테스트")
    public void createCars(){
        String names = "lee,kim,park";
        Cars cars = new Cars(names);


    }
}
