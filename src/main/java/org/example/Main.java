package org.example;

import java.util.Scanner;

public class Main {
    static final Scanner in= new Scanner(System.in);
    static int choice;
    static char toContinue = 'y';
    static String inputString;
    static StringMethods stringMethods=new StringMethodsImpl();
    public static void main(String[] args) {


        do {
            choice = getInputForChoice();
            try {
                switch(choice) {
                    case 1:
                        inputString = getInputString();
                        if (imProperInput(inputString)){
                            continue;
                        }
                        else {
                            printSwapResultToConsole(inputString, stringMethods);
                        }
                        break;

                    case 2:
                        inputString = getInputString();
                        if(imProperInput(inputString)) {
                            continue;
                        }
                        else if(stringMethods.palindromeOrNot(inputString) == 10) {
                            System.out.println("Given string is Palindrome:\n");
                        }
                        else {
                            System.out.println("Given string is not a Palindrome:\n");
                        }
                        break;

                    case 3:
                        inputString = getInputString();
                        if(imProperInput(inputString)) {
                            continue;
                        }
                        else {
                            printDuplicateMethodOutputToConsole(inputString, stringMethods);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + choice);
                }
            }catch (NumberNotAllowedException e){
                numberAllowedCheck();
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            toContinue = getInputForContinue();
        }while (toContinue == 'Y' || toContinue == 'y');
    }

    private static int getInputForChoice() {
        int choice;
        System.out.println("" +
                " Choose options: \n" +
                " 1.Swap last two characters \n" +
                " 2.Check palindrome or not\n" +
                " 3.Remove duplicates from string\n" );

        choice= in.nextInt();
        in.nextLine();
        return choice;
    }
    private static char getInputForContinue() {
        char toContinue;
        System.out.println("Enter Y to continue N to exit");
        toContinue = in.next().charAt(0);
        return toContinue;
    }
    private static void printDuplicateMethodOutputToConsole(String inputString, StringMethods stringMethods) throws NumberNotAllowedException {
        System.out.println("Before removing duplicates from the string is:\n" + inputString);
        System.out.println("After Removing duplicates from the string is:\n"
                + stringMethods.removeDuplicatesFromString(inputString) );
    }
    private static boolean imProperInput(String inputString) {
        if(emptyStringCheck(inputString)){
            System.out.println("You entered an empty string\n");
            return true;
        } else if (spaceAtStart(inputString)) {
            System.out.println("You entered a string starting with space which is not allowed\n");
            return true;
        }

        return false;
    }
    private static boolean spaceAtStart(String inputString) {
        return inputString.charAt(0) == ' ';
    }
    private static boolean emptyStringCheck(String inputString)  {
        return inputString.isEmpty();
    }
    private static void printSwapResultToConsole(String inputString,
                                                 StringMethods stringMethods)
            throws NumberNotAllowedException {
        System.out.println("Before swapping string is:\n" + inputString);
        System.out.println("After swapping string is:\n"
                + stringMethods.swapOnlyLastTwoCharacters(inputString));
    }
    private static String getInputString() {
        System.out.println("Enter string");
        return in.nextLine();
    }
    private static void numberAllowedCheck() {

            System.out.println("The string contains number do you want to check including numbers (Y/N)??");
            char choiceForIncludingNumber = in.next().charAt(0);
            if(choiceForIncludingNumber == 'Y' || choiceForIncludingNumber == 'y'){
                StringMethodsImpl.switchNumberAllowedTrue();
            } else if (choiceForIncludingNumber == 'N' || choiceForIncludingNumber == 'n') {
                System.out.println("Give input next time without numbers");
            }
            else {
                System.out.println("Invalid Input taking it as no and proceeding");
            }

    }
}


