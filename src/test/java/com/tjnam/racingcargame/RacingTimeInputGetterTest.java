package com.tjnam.racingcargame;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTimeInputGetterTest {

    private static RacingTimeInputGetter racingTimeInputGetter;

    @BeforeAll
    public static void setUp(){
        racingTimeInputGetter = new RacingTimeInputGetter();
    }

    @Test
    public void validateRacingTimeTest(){

        try {
            Method validateRacingTimeMethod = racingTimeInputGetter.getClass()
                    .getDeclaredMethod("isValidateRacingTime", int.class);
            validateRacingTimeMethod.setAccessible(true);

            int racingTimeInput = 0;
            boolean isValid = (boolean) validateRacingTimeMethod.invoke(racingTimeInputGetter, racingTimeInput);
            assertThat(isValid).isTrue();

            racingTimeInput = 1;
            isValid = (boolean) validateRacingTimeMethod.invoke(racingTimeInputGetter, racingTimeInput);
            assertThat(isValid).isFalse();

            racingTimeInput = 5000;
            isValid = (boolean) validateRacingTimeMethod.invoke(racingTimeInputGetter, racingTimeInput);
            assertThat(isValid).isFalse();

            racingTimeInput = -200;
            isValid = (boolean) validateRacingTimeMethod.invoke(racingTimeInputGetter, racingTimeInput);
            assertThat(isValid).isTrue();

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


    }

}
