package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNameInputGetterTest {

    private static CarNameInputGetter carNameInputGetter;
    private String[] splitedUserInputCarName;

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

            splitedUserInputCarName = (String[]) splitUserInputTestMethod.invoke(carNameInputGetter, userInputData);
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

}
