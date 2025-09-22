package com.kce.logistics.util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static String prompt(String msg) {
        System.out.print(msg);
        return scanner.nextLine().trim();
    }
}
