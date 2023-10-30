package com.alekseigrin.algos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static com.alekseigrin.algos.MinimalDistance.*;

class MinimalDistanceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void minimalDistance_ifMoreThemTwoValidParams_shouldBeCorrectExecutedWithoutExceptions() {
        main(new String[] {"word1", "word2", "word3", "word4"});
        assertEquals("1\n",outContent.toString());

        main(new String[] {"word12", "word21"});
        assertEquals("1\n2\n",outContent.toString());

        main(new String[] {"12345", "67890"});
        assertEquals("1\n2\n5\n",outContent.toString());

        assertDoesNotThrow(() -> {
            main(new String[] {"word1", "word2", "word3", "word4"});
        });
    }

    @Test
    void minimalDistance_paramsNotValid_shouldThrowException() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {main(new String[] {"word1"});});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {main(new String[] {""});});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {main(new String[0]);});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {main(new String[] {"word1", ""});});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {main(new String[] {"", "word2"});});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {minimalDistance("word1", "");});
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {minimalDistance("", "word2");});
    }

    @Test
    void minimalDistance_ifBothOrOneOfStringsLengthZero_shouldPass() {
        assertDoesNotThrow(() -> {main(new String[] {"", ""});});
        assertDoesNotThrow(() -> {minimalDistance("", "");});
    }

}