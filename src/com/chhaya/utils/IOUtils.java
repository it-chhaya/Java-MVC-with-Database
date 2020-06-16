package com.chhaya.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IOUtils {

    public static int inputInteger(String instruction) {
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.print(instruction);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("You can input only integer number");
            }
        } while (true);
    }

    public static String inputString(String instruction) {
        Pattern regex = Pattern.compile("[^A-Za-z]");
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print(instruction);
            String name = scanner.nextLine();
            Matcher m = regex.matcher(name);
            if (m.find())
                System.out.println("Name cannot contain special characters");
            else
                return name;
        } while (true);

    }

}
