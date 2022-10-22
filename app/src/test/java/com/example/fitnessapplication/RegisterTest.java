package com.example.fitnessapplication;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class RegisterTest {
    static Register register;

    @BeforeClass
    public static void setup() {
        register = new Register();
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    @Test
    public void isPasswordLength() {
        assertTrue(register.isPasswordLength("111"));
    }

    @Test
    public void isPasswordEmpty() {
        assertTrue(register.isPasswordEmpty(""));
    }

    @Test
    public void isEmailEmpty() {
        assertTrue(register.isEmailEmpty(""));
    }
}