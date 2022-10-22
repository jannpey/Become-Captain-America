package com.example.fitnessapplication;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class LoginTest {
    static Login logins;

    @BeforeClass
    public static void setup() {
        logins = new Login();
    }
    @AfterClass
    public static void tearDown() {
        System.gc();
    }
    @Test
    public void isPasswordLength() {
        assertTrue(logins.isPasswordLength("111"));
    }

    @Test
    public void isPasswordEmpty() {
        assertTrue(logins.isPasswordEmpty(""));
    }

    @Test
    public void isEmailEmpty() {
        assertTrue(logins.isEmailEmpty(""));
    }
}