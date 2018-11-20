package lv.ctco.notepad;

import java.io.File;
import java.util.*;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Person> records = new ArrayList<>();
   // private static final File RESULTS_FILE = new File("persons.txt");

    public static void main(String[] args) {
        System.out.println("Notepad application.\n--------------==============--------------");
        showHelp();

        for(;;){
            System.out.println("Please, enter command:");
            String cmd = scanner.next();
            switch (cmd) {
                case "c":
                    createPerson();
                    break;
                case "h":
                    showHelp();
                    break;
                case "l":
                    showList();
                    break;
                case "d":
                    deleteRecord();
                    break;
                case "e":
                    System.out.println("Auf viedersehen");
                    return;
                default:
                    System.out.println("Wrong command. Type 'help' to see the list.");
            }
        }
    }
    private static void showList() {
        records.forEach(r -> System.out.println(r));
    }

    private static void showHelp() {
        System.out.println("List of available commands:");
        System.out.println("create: adds person to ");
        System.out.println("list: shows list of persons");
        System.out.println("delete: delete person with given id");
        System.out.println("help: shows current help ");

    }
    private static void createPerson() {
        Person person = new Person();

        person.setName(askString("Enter person's name:"));
        person.setSurname(askString("Enter person's surname:"));
        person.setPhone(validatePhone());
        person.setEmail(askString("Enter person's e-mail:"));

        records.add(person);
    }

    private static String askString(String msg) {
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
        Person personTodelete = null;

        for(Person person : records){
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

    private static String validatePhone() {
        String phoneNumber = askString("Enter person's phone:");
        while(phoneNumber.length() <5) {
            System.out.println("Phone number is too short, enter at least 5 symbols");
            phoneNumber = askString("Enter person's phone:");
        }
        return phoneNumber;
    }
}
