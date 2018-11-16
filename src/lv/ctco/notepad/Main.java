package lv.ctco.notepad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> records = new ArrayList<>();

    public static void main(String[] args) {
        for(;;){
            System.out.println("cmd:");
            String cmd = scanner.next();
            switch (cmd) {
                case "create":
                    createPerson();
                    break;
                case "help":
                    showHelp();
                    break;
                case "showList":
                    showList();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command");
            }
        }
    }
    private static void showList() {

    }
    private static void showHelp() {

    }
    private static void createPerson() {

    }
}
