package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ServiceTest {
    @Test
    @DisplayName("is Singleton pattern working")
    void testGetInstance() {
        Service service1 = Service.getInstance();
        Service service2 = Service.getInstance();
        assertTrue(service1 == service2);
    }

    @ParameterizedTest
    @DisplayName("is generated percent list size same as car length and each percent is between 0 and 9")
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 })
    void testGeneratePercent(Integer carLength) {
        Service service = Service.getInstance();
        List<Integer> percentList = service.generatePercent(carLength);
        assertTrue(percentList.size() == carLength);
        assertTrue(percentList.stream().allMatch(percent -> percent >= 0 && percent <= 9));
    }
}
