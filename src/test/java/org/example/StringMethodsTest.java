package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    StringMethods temp = new StringMethodsImpl();
    @Test
    void should_return_sameStringWhenOneCharacterGiven(){

        String actual = temp.swapOnlyLastTwoCharacters("a");
        String expected = "a";
        assertEquals(expected, actual);

    }

    @Test
    void should_Return_reversedStringWhenTwoCharactersGiven(){

        String actual = temp.swapOnlyLastTwoCharacters("TI");
        String expected = "IT";
        assertEquals(expected, actual);
    }
    @Test
    void should_return_reversedStringWIthMorethanTwoChars(){

        String actual = temp.swapOnlyLastTwoCharacters("FORD");
        String expected = "FODR";
        assertEquals(expected, actual);

    }
    @Test
    void should_return_emptyStringWhenEmptyStringGiven(){

        String actual = temp.swapOnlyLastTwoCharacters("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void should_Return_0ForNonPalindromeString(){

        int expected = 0;
        int actual = temp.palindromeOrNot("abc");
        assertEquals(expected, actual);
    }

    @Test
    void should_Return_Negative1WhenEmptyStringGiven(){
        int expected = -1;
        int actual = temp.palindromeOrNot("");
        assertEquals(expected, actual);
    }
    @Test
    void should_return_1whenStringLengthIsOne()
    {
        int expected = 10;
        int actual = temp.palindromeOrNot("a");
        assertEquals(expected, actual);
    }

    @Test
    void should_return_10whenStringLengthisGreaterThan1AndPalindrome(){
        int expected = 10;
        int actual =temp.palindromeOrNot("abbba");
        assertEquals(expected, actual);
    }

    @Test
    void should_return_abcForremoveDuplicates(){
        // String.StringMethods temp = new String.StringMethods();

        String expected = "abc";
        String actual= temp.removeDuplicatesFromString("aabbcc");
        assertEquals(actual,expected);
    }


}