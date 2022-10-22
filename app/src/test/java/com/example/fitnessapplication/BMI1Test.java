package com.example.fitnessapplication;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class BMI1Test {

    static BMI1 bmi;

    @BeforeClass
    public static void setup() {
        bmi = new BMI1();
    }

    @AfterClass
    public static void tearDown() {
        System.gc();
    }

    @Test
    public void calBMI() {
        assertEquals(bmi.calBMI("1.65","50"),"Result: \n\n6.6");
    }
}