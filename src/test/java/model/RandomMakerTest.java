package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class RandomMakerTest {

    @Test
    void getRandomValue() {
        //given
        List<Integer> randList = new ArrayList<>();
        RandomMaker rm = new RandomMaker();

        //when
        for(int i=0;i<100;i++){
            randList.add(rm.getRandomValue());
        }

        //then

        assertEquals(100,randList.stream().filter(e->e>=0 && e<10).count());

    }
}