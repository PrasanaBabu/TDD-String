package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int choice;
        String inputString;
        StringMethods s=new StringMethodsImpl();
        do{
            Scanner in=new Scanner(System.in);
            System.out.println("" +
                    " Choose options: \n" +
                    " 1.Swap last two characters \n" +
                    " 2.Check palindrome or not\n" +
                    " 3.Remove duplicates from string\n" +
                    "  Enter 0 to exit\n");

            choice=in.nextInt();
            in.nextLine();
            switch(choice)
            {
                case 1:
                    System.out.println("Enter string");
                    inputString=in.next();
                    System.out.println("Before swapping string is:\n" + inputString);
                    System.out.println("After swapping string is:\n"
                            + s.swapOnlyLastTwoCharacters(inputString));
                    break;
                case 2:
                    System.out.println("Enter string\n");
                    inputString=in.nextLine();
                    if( s.palindromeOrNot(inputString) == -1)
                    {
                        System.out.println("You entered an empty string\n");
                    }
                    else if(s.palindromeOrNot(inputString) == 10) {
                        System.out.println("Given string is Palindrome:\n");
                    }
                    else
                    {
                        System.out.println("Given string is not a Palindrome:\n");
                    }
                    break;
                case 3:
                    System.out.println("Enter string");
                    inputString=in.next();
                    System.out.println("Before removing duplicates from the string is:\n" + inputString);
                    System.out.println("After Removing duplicates from the string is:\n"
                            + s.removeDuplicatesFromString(inputString) );
                    break;
            }
        }while (choice!=0);
    }
}


