package main;

import util.MenuUtil;


public class Main {
    public static void main(String[] args) {
        while (true) {
            int menu = util.InputUtil.inputNumber("Student registration menu" +
                    "\n 1. Register student" +
                    "\n 2. Show all student" +
                    "\n 3. Find student" +
                    "\n 4. Update student" +
                    "\n 5. Exit");
            MenuUtil.processMenu(menu);
        }
    }

}
