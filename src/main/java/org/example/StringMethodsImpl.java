package org.example;

import java.util.Arrays;

public class StringMethodsImpl implements StringMethods {

    private static boolean numberAllowed = false;
    @Override
    public String swapOnlyLastTwoCharacters(String str) throws NumberNotAllowedException {

        if(!proceedWithNumberAlso(str)){
            throwError();
        }


        if (str.length() == 1 || str.length() == 0) {
            return str;
        }
        else {
            return getStringWithLastTwoCharactersSwapped(str);
        }
    }

    private void throwError() throws NumberNotAllowedException {
        throw new NumberNotAllowedException("Please provide string without numbers");
    }

    private static String getStringWithLastTwoCharactersSwapped(String str) {
        char[] strArray = str.toCharArray();

        char temp = strArray[ str.length() - 1 ];
        strArray[ strArray.length - 1 ] = strArray[ strArray.length - 2 ];
        strArray[ strArray.length - 2 ] = temp;

        return new String(strArray);
    }

    //Returns  -1 when empty; 1 when single char; 10 when palindrome; 0 when not palindrome
    @Override
    public int palindromeOrNot(String inputString) throws NumberNotAllowedException {
        if(!proceedWithNumberAlso(inputString)){
            throwError();
        }
        if(inputString.isEmpty()) {
            return -1;
        }
        String reversedString = getReversedString(inputString);

        return reversedString.equals(inputString) ? 10 : 0;
    }

    private static String getReversedString(String inputString) {
        StringBuilder outputString = new StringBuilder(inputString);
        outputString.reverse();
        return outputString.toString();
    }

    @Override
    public String removeDuplicatesFromString(String inputString) throws NumberNotAllowedException {
        if(!proceedWithNumberAlso(inputString)){
            throwError();
        }

        char[] str =inputString.toCharArray();
        int newArrayIndex = 0;
        for(int firstIndex = 0; firstIndex < str.length; firstIndex++) {
            int secondIndex;
            for(secondIndex = 0; secondIndex < firstIndex; secondIndex++) {
                if(str[firstIndex] == str[secondIndex]) {
                    break;
                }
            }
            if(firstIndex == secondIndex) {
                str[newArrayIndex++] = str[firstIndex];
            }
        }
        return String.valueOf(Arrays.copyOf(str,newArrayIndex));
    }

    public static boolean proceedWithNumberAlso(String stringToCheckForNumber){

        if(numberAllowed) {
            return true;
        }
        char[] singleCharacters = stringToCheckForNumber.toCharArray();
        for (char charToCheck : singleCharacters){
            if(charToCheck >= '0' && charToCheck <= '9'){
                return false;
            }
        }
        return true;
    }
    public static void switchNumberAllowedTrue(){
        numberAllowed = true;
    }
    public static void switchNumberAllowedFalse(){
        numberAllowed = false;
    }
}
