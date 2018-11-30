package lv.ctco.notepad;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static java.time.format.DateTimeFormatter.ofPattern;

public class Main {
    private static final String DATE_PATTERN = "dd-MM-uuuu";
    private static final String TIME_PATTERN = "HH:mm";
    static final DateTimeFormatter DATE_FORMATTER = ofPattern(DATE_PATTERN);
    static final DateTimeFormatter TIME_FORMATTER = ofPattern(TIME_PATTERN);
    private static Scanner scanner = new Scanner(System.in);
    private static List<Record> records = new ArrayList<>();
   // private static final File RESULTS_FILE = new File("persons.txt");

    public static void main(String[] args) {
        System.out.println("Notepad application.\n--------------==============--------------");
        showHelp();

        for(;;){
            System.out.println("Please, enter command:");
            String cmd = scanner.next();
            switch (cmd) {
                case "cn":
                case "createnote":
                    createRecord(new StickyNote());
                    break;
                case "cp":
                case "createperson":
                    createRecord(new Person());
                    break;
                case "cr":
                case "createreminder":
                    createRecord(new Reminder());
                    break;
                case "ca":
                case "createalarm":
                    createRecord(new Alarm());
                    break;
                case "h":
                case "help":
                    showHelp();
                    break;
                case "l":
                case "list":
                    showList();
                    break;
                case "s":
                case "search":
                    searchRecord();
                    break;
                case "d":
                case "delete":
                    deleteRecord();
                    break;
                case "e":
                case "exit":
                    System.out.println("Auf viedersehen");
                    return;
                default:
                    System.out.println("Wrong command. Type 'help' to see the list.");
            }
        }
    }

    private static void searchRecord() {
        String ss = askString("Enter search string:");
        records.stream()
                .filter(r -> r.contains(ss))
                .forEach(System.out::println);
    }

    private static void createRecord(Record record) {
        record.askData();
        records.add(record);
//        System.out.println(record);
    }

    private static void showList() {
        records.forEach(System.out::println);
    }

    private static void showHelp() {
        System.out.println("List of available commands:");
        System.out.println("\t create: adds person to ");
        System.out.println("\t list: shows list of persons");
        System.out.println("\t search: searches for different fignja");
        System.out.println("\t delete: delete person with given id");
        System.out.println("\t help: shows current help ");

    }


    static String askString(String msg) {
        String returnedString;
        while (true) {
            System.out.println(msg);
            returnedString = scanner.next();
            if (returnedString.startsWith("\"")) {
                List<String> stringList = getValuesList(returnedString);
                returnedString = String.join(" ", stringList);
            }
            if (returnedString.length() <= 1) {
                System.out.println("Entered value is too short");
            } else {
                break;
            }
        }

        return returnedString;
    }

    static LocalDate askDate(String msg){
        LocalDate localDate;
        while (true) {
            try {
                String strDate = askString(msg);
                localDate = LocalDate.parse(strDate, DATE_FORMATTER);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Format is wroong:");
            }
        }
        return localDate;
    }

    static LocalTime askTime(String msg) {
        LocalTime localTime;
        while (true) {
            try {
                String strTime = askString(msg);
                localTime = LocalTime.parse(strTime, TIME_FORMATTER);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Wrong time format");
            }
        }
        return localTime;
    }

    private static List<String> getValuesList(String returnedString) {
        List<String> stringList = new ArrayList<>();
        stringList.add(returnedString);
        String tmpString;
        do {
            tmpString = scanner.next();
            stringList.add(tmpString);
        }
        while (!tmpString.endsWith("\""));
        return stringList;
    }


    private static void deleteRecord() {
        System.out.println("Enter ID of record You would like to delete");
        int enteredID = getEnteredNumber();
        Record personTodelete = null;

        for(Record person : records){
            if (person.getId() == enteredID) {
                personTodelete = person;
            }
        }
        if (personTodelete != null) {
            records.remove(personTodelete);
        }
    }

    private static int getEnteredNumber() {
        while(true) {
            if (records.size() == 0) {
                System.out.println("You have an empty list nothing to delete");
                return 0;
            }
            try {
                int enteredNumber = scanner.nextInt();

                if (Optional.empty().equals(records.stream().filter(person -> person.getId() == enteredNumber).findFirst())) {
                    System.out.println("Error! current ID is not presented, please check list.");
                    continue;
                }
                return enteredNumber;
            } catch (InputMismatchException e) {
                scanner.next();
                System.out.println("Please enter a number. Cheater durackij. " + e);
            }
        }

    }

     static String validatePhone() {
        String phoneNumber = askString("Enter person's phone:");
        while(phoneNumber.length() <5) {
            System.out.println("Phone number is too short, enter at least 5 symbols");
            phoneNumber = askString("Enter person's phone:");
        }
        return phoneNumber;
    }
}
