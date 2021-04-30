package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameInputGetterTest {

    private static CarNameInputGetter carNameInputGetter;

    @BeforeAll
    public static void setUp(){
        carNameInputGetter = new CarNameInputGetter();
    }

    @Test
    public void splitUserInputTest(){
        try {
            Method splitUserInputTestMethod = carNameInputGetter.getClass().getDeclaredMethod("splitUserInput", String.class);
            splitUserInputTestMethod.setAccessible(true);
            String userInputData = "abc,abcd,abcde,abcdef,abcdefg";

            String[] splitedUserInputCarName = (String[]) splitUserInputTestMethod.invoke(carNameInputGetter, userInputData);
            assertThat(splitedUserInputCarName[0]).isEqualTo("abc");
            assertThat(splitedUserInputCarName[1]).isEqualTo("abcd");
            assertThat(splitedUserInputCarName[2]).isEqualTo("abcde");
            assertThat(splitedUserInputCarName[3]).isEqualTo("abcdef");
            assertThat(splitedUserInputCarName[4]).isEqualTo("abcdefg");
            assertThat(splitedUserInputCarName.length).isEqualTo(5);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void convertStringsToCarName(){
        String[] carNameInputs = new String[5];
        for (int i=0 ; i<5 ; i++) {
            carNameInputs[i] = "cars" + i;
        }
        try {
            Method convertStringToCarName = carNameInputGetter.getClass()
                    .getDeclaredMethod("convertStringToCarName", String[].class);
            convertStringToCarName.setAccessible(true);
            List<CarName> carNameList = (List<CarName>) convertStringToCarName.invoke(carNameInputGetter, (Object) carNameInputs);
            assertThat(carNameList.size()).isEqualTo(5);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
