package racinggame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DisplayTest {

    @Test
    void winner() {
        Display.winner(Arrays.asList("abc", "def", "ghi"));

    }
}