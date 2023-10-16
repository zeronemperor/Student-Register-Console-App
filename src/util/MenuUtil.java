package util;

public class MenuUtil {
    public static void processMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1 -> util.StudentUtil.registerStudent();
            case 2 -> util.StudentUtil.printAllStudent();
            case 3 -> util.StudentUtil.findStudentAndPrint();
            case 4 -> util.StudentUtil.updateStudentWithNewObject();
            case 5 -> System.exit(0);
        }
    }

    public static String requireName() {
        return InputUtil.inputText("enter name");
    }

    public static String requireSurname() {
        return InputUtil.inputText("enter surname");
    }

    public static int requireAge() {
        return InputUtil.inputNumber("enter age");
    }

    public static String requireClassName() {
        return InputUtil.inputText("enter className");
    }

    public static void showSuccessOpMessage() {
        System.out.println("Operation completed successfully");
    }
}
