package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.AnswerPrinter;
import src.Car;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AnswerPrinterTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    private AnswerPrinter answerPrinter;
    private Car[] cars;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        answerPrinter = new AnswerPrinter();
        cars = new Car[] { new Car("Car1"), new Car("Car2"), new Car("Car3") };
    }

    @Test
    public void testPrintEffect() {
        cars[0].increasePosition();
        answerPrinter.printEffect(cars);
        String expectedOutput = "Car1 : -\nCar2 : \nCar3 : \n\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testPrintWinner() {
        StringBuilder winner = new StringBuilder("Car1");
        answerPrinter.printWinner(winner);
        String expectedOutput = "최종 우승자 : Car1\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testExpressCarInfoToString() {
        cars[0].increasePosition();
        StringBuilder result = answerPrinter.expressCarInfoToString(cars[0]);
        assertEquals("Car1 : -", result.toString());
    }
}
