package controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ServiceTest {
    @Test
    @DisplayName("is Singleton pattern working")
    void testGetInstance() {
        Service service1 = Service.getInstance();
        Service service2 = Service.getInstance();
        assertTrue(service1 == service2);
    }
}
