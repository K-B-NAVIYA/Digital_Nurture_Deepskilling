package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LifeCycleTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();   // Arrange
        System.out.println("Setup completed");
    }

    @AfterEach
    void tearDown() {
        calculator = null;               // Cleanup
        System.out.println("Teardown completed");
    }

    @Test
    void testAdd() {

        // Arrange
        int a = 1;
        int b = 2;

        // Act
        int result = calculator.add(a, b);

        // Assert
        assertEquals(3, result);
    }

    @Test
    void testSubtract() {

        // Arrange
        int a = 5;
        int b = 3;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(2, result);
    }
}