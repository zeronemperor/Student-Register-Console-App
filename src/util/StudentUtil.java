package util;

import bean.Student;
import jdk.jshell.execution.Util;
import main.Config;

import java.sql.SQLOutput;
import java.util.Scanner;

public class StudentUtil {
    public static Student fillStudents() {
        String name = MenuUtil.requireName();
        String surname = MenuUtil.requireSurname();
        int age = MenuUtil.requireAge();
        String className = MenuUtil.requireClassName();

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void registerStudent() {
        int count = InputUtil.inputNumber("How many student register?");
        Config.students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ".Register");
            Config.students[i] = fillStudents();
        }
        MenuUtil.showSuccessOpMessage();
        StudentUtil.printAllStudent();
    }

    public static void printAllStudent() {
        if (Config.students == null) {
            System.out.println("Student not registered.");

        } else {
            for (int i = 0; i < Config.students.length; i++) {
                Student st = Config.students[i];
                System.out.println((i + 1) + ".Register student");
                System.out.println("--------------------------------");
                System.out.println(st.getFullInfo());
                System.out.println("--------------------------------");
            }
        }
    }

    public static Student[] findStudent(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text)) {
                count++;
            }
        }

        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void findStudentAndPrint() {
        String text = InputUtil.inputText("Enter student name or surname");
        Student[] foundStudent = findStudent(text);
        for (int i = 0; i < foundStudent.length; i++) {
            System.out.println(foundStudent[i].getFullInfo());
        }

    }

    public static void updateStudentWithNewObject() {
        printAllStudent();
        int i = util.InputUtil.inputNumber("Which student do you want to update? ");
        System.out.println("Enter new information for student");
        Student s = fillStudents();
        Config.students[i - 1] = s;
    }

    public static void updateStudentWithSameObject() {
        printAllStudent();
        int i = util.InputUtil.inputNumber("Which student do you want to update? ");

        System.out.println("Enter new information for student");
        Student selectedStudent = Config.students[i - 1];

        String changeParam = InputUtil.inputText("What do you to change? ('name','surname','age'.'className'");
        if (changeParam.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requireName());
        }
        if (changeParam.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requireSurname());
        }
        if (changeParam.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requireAge());
        }
        if (changeParam.contains("'className'")) {
            selectedStudent.setClassName(MenuUtil.requireClassName());
        }

    }

    public void updateStudentWithSplit() {
        printAllStudent();
        int index = util.InputUtil.inputNumber("Which student do you want to update? ");

        System.out.println("Enter new information for student");
        Student selectedStudent = Config.students[index - 1];

        String changeParam = InputUtil.inputText("What do you to change? (name,surname,age.className");
        String[] parametrs = changeParam.split(",");
        for (int i = 0; i < parametrs.length; i++) {
            String param = parametrs[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requireName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requireSurname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requireAge());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requireClassName());
            }
        }
    }
}
