package com.example.textcounter;

import org.junit.Test;
import static org.junit.Assert.*;

public class TextCounterTest {

    private final TextCounter counter = new TextCounter();

    @Test
    public void testCountWords_emptyString_returnsZero() {
        assertEquals(0, counter.countWords(""));
    }

    @Test
    public void testCountWords_normalText_returnsCorrectCount() {
        assertEquals(3, counter.countWords("Hello world here"));
    }

    @Test
    public void testCountCharacters_returnsCorrectCount() {
        assertEquals(11, counter.countCharacters("hello world"));
    }
}
