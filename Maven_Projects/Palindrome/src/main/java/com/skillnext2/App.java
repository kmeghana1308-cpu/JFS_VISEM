package com.skillnext2;

import java.util.Scanner;

public class App {

    // Non-static method for String
    public boolean isPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        return s.equalsIgnoreCase(rev);
    }

    // Non-static method for Number
    public boolean isPalindrome(int num) {
        return isPalindrome(String.valueOf(num));  // Convert number to String
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Input Type:");
        System.out.println("1. String");
        System.out.println("2. Number");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();
        sc.nextLine();  // clear buffer

        if (choice == 1) {
            System.out.print("Enter a string: ");
            String str = sc.nextLine();
            System.out.println("Palindrome: " + isPalindrome(str));
        } 
        else if (choice == 2) {
            System.out.print("Enter a number: ");
            int num = sc.nextInt();
            System.out.println("Palindrome: " + isPalindrome(num));
        } 
        else {
            System.out.println("Invalid Choice!");
        }

        sc.close();
    }

    public static void main(String[] args) {
        App obj = new App();  // Object creation
        obj.run();  // Calling non-static method
    }
}

