package com.example.fitnessapplication;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class FeedbackTest {
    static Feedback feedback;

    @BeforeClass
    public static void setup() {
        feedback = new Feedback();
    }
    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    @Test
    public void isNameEmpty() {
        assertTrue(feedback.isNameEmpty(""));
    }

    @Test
    public void isFeedbackEmpty() {
        assertTrue(feedback.isNameEmpty(""));
    }
}