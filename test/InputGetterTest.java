package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.InputGetter;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InputGetterTest {

    private InputGetter inputGetter;

    @BeforeEach
    public void setUp() {
        inputGetter = new InputGetter();
    }

    @Test
    public void testGetUserName() throws IOException {
        String input = "Car1,Car2,Car3\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        String[] userNames = inputGetter.getUserName();
        assertArrayEquals(new String[]{"Car1", "Car2", "Car3"}, userNames);
    }

    @Test
    public void testGetNumberOfTry() throws IOException {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        int numberOfTry = inputGetter.getNumberOfTry();
        assertEquals(5, numberOfTry);
    }
}
