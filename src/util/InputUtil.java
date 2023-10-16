package util;

import java.util.Scanner;

public class InputUtil {
    public static String inputText(String title) {
        Scanner scn = new Scanner(System.in);
        System.out.println(title);
        String answer = scn.nextLine();
        return answer;
    }

    public static int inputNumber(String title) {
        Scanner scn = new Scanner(System.in);
        System.out.println(title);
        int answer = scn.nextInt();
        return answer;
    }
}
