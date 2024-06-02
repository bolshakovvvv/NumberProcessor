package com.test;

import org.example.NumberProcessor;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass {

    NumberProcessor obj;

    public TestClass() throws IOException {
        this.obj = new NumberProcessor();
    }

    @Test
    public void testGetSum(){
        assertEquals(15, obj.getSum());
    }

    @Test
    public void testGetMax(){
        assertEquals(5, obj.getMax());
    }

    @Test
    public void testGetMin(){
        assertEquals(1, obj.getMin());
    }

    @Test
    public void testGetMult(){
        assertEquals(BigInteger.valueOf(120), obj.getMult());
    }

}
