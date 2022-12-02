package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        char toContinue = 0;
        String inputString;
        StringMethods stringMethods=new StringMethodsImpl();
        do{
            Scanner in=new Scanner(System.in);
            System.out.println("" +
                    " Choose options: \n" +
                    " 1.Swap last two characters \n" +
                    " 2.Check palindrome or not\n" +
                    " 3.Remove duplicates from string\n" );

            choice=in.nextInt();
            in.nextLine();

            try {

                switch(choice)
                {

                    case 1:
                        inputString = getInputString(in);

                        if (!inputFormatCheck(inputString)){
                            continue;
                        }
                        else {
                            printSwapResultToConsole(inputString, stringMethods);
                        }
                        break;

                    case 2:
                        inputString = getInputString(in);
                        if(!inputFormatCheck(inputString)) {
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
                        inputString = getInputString(in);
                        if(!inputFormatCheck(inputString)) {
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
                numberAllowedCheck(in);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
            toContinue = getInputForContinue(in);
        }while (toContinue == 'Y' || toContinue == 'y');
    }

    private static char getInputForContinue(Scanner in) {
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
    private static boolean inputFormatCheck(String inputString) {
        if(emptyStringCheck(inputString)){
            System.out.println("You entered an empty string\n");
            return false;
        } else if (spaceAtStart(inputString)) {
            System.out.println("You entered a string starting with space which is not allowed\n");
            return false;
        }

        return true;
    }

    private static boolean spaceAtStart(String inputString) {
        return inputString.charAt(0) == ' ';
    }

    private static boolean emptyStringCheck(String inputString)  {
        return inputString.isEmpty();
    }

    private static void printSwapResultToConsole(String inputString, StringMethods stringMethods) throws NumberNotAllowedException {
        System.out.println("Before swapping string is:\n" + inputString);
        System.out.println("After swapping string is:\n"
                + stringMethods.swapOnlyLastTwoCharacters(inputString));
    }

    private static String getInputString(Scanner in) {
        System.out.println("Enter string");
        return in.nextLine();
    }


    private static void numberAllowedCheck(Scanner in) {

            System.out.println("The string contains number do you want to check including numbers (Y/N)??");
            char choiceForIncludingNumber = in.next().charAt(0);
            if(choiceForIncludingNumber == 'Y' || choiceForIncludingNumber == 'y'){
                StringMethodsImpl.switchNumberAllowed();
            } else if (choiceForIncludingNumber == 'N' || choiceForIncludingNumber == 'n') {
                System.out.println("Give input next time without numbers");
            }
            else {
                System.out.println("Invalid Input taking it as no and proceeding");
            }

    }
}


