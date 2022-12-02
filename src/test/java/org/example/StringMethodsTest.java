package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMethodsTest {

    StringMethods temp = new StringMethodsImpl();
    @Test
    void should_return_sameStringWhenOneCharacterGiven() throws NumberNotAllowedException {

        String actual = temp.swapOnlyLastTwoCharacters("a");
        String expected = "a";
        assertEquals(expected, actual);

    }

    @Test
    void should_Return_reversedStringWhenTwoCharactersGiven() throws NumberNotAllowedException {

        String actual = temp.swapOnlyLastTwoCharacters("TI");
        String expected = "IT";
        assertEquals(expected, actual);
    }
    @Test
    void should_return_reversedStringWIthMorethanTwoChars() throws NumberNotAllowedException {

        String actual = temp.swapOnlyLastTwoCharacters("FORD");
        String expected = "FODR";
        assertEquals(expected, actual);

    }
    @Test
    void should_return_emptyStringWhenEmptyStringGiven() throws NumberNotAllowedException {

        String actual = temp.swapOnlyLastTwoCharacters("");
        String expected = "";
        assertEquals(expected, actual);
    }

    @Test
    void should_Return_0ForNonPalindromeString() throws NumberNotAllowedException {

        int expected = 0;
        int actual = temp.palindromeOrNot("abc");
        assertEquals(expected, actual);
    }

    @Test
    void should_Return_Negative1WhenEmptyStringGiven() throws NumberNotAllowedException {
        int expected = -1;
        int actual = temp.palindromeOrNot("");
        assertEquals(expected, actual);
    }
    @Test
    void should_return_1whenStringLengthIsOne() throws NumberNotAllowedException {
        int expected = 10;
        int actual = temp.palindromeOrNot("a");
        assertEquals(expected, actual);
    }

    @Test
    void should_return_10whenStringLengthisGreaterThan1AndPalindrome() throws NumberNotAllowedException {
        int expected = 10;
        int actual =temp.palindromeOrNot("abbba");
        assertEquals(expected, actual);
    }

    @Test
    void should_return_abcForremoveDuplicates() throws NumberNotAllowedException {
        // String.StringMethods temp = new String.StringMethods();

        String expected = "abc";
        String actual= temp.removeDuplicatesFromString("aabbcc");
        assertEquals(actual,expected);
    }

    @Test
    void should_throwException_When_StringContainsNumberForPalindromeCheck(){

        StringMethodsImpl.switchNumberAllowedFalse();
        assertThrows(NumberNotAllowedException.class,
                () -> temp.palindromeOrNot("123")  );

    }
    @Test
    void should_throwException_When_StringContainsNumberForLastTwoSwap(){

        StringMethodsImpl.switchNumberAllowedFalse();
        assertThrows(NumberNotAllowedException.class,
                () -> temp.swapOnlyLastTwoCharacters("123")  );

    }

    @Test
    void should_throwException_When_StringContainsNumberForDuplicateRemoval(){

        StringMethodsImpl.switchNumberAllowedFalse();
        assertThrows(NumberNotAllowedException.class,
                () -> temp.removeDuplicatesFromString("123")  );

    }

    @Test
    void should_return_true_when_stringPassedWithNumberAllowed(){
        StringMethodsImpl.switchNumberAllowedTrue();
        assertTrue(StringMethodsImpl.proceedWithNumberAlso("123"));
    }
    @Test
    void should_return_false_when_stringPassedWithNumberNotAllowed(){

        assertFalse(StringMethodsImpl.proceedWithNumberAlso("123"));
    }
    @Test
    void should_return_true_when_stringPassedWithNumberNotAllowedGivingNoNumber(){

        assertTrue(StringMethodsImpl.proceedWithNumberAlso("abc"));
    }



}