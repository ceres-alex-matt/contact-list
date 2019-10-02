import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class ContactsManager {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(); // Create lines List
//        titleMenu(lines);
//        readList("src/contacts.txt", lines);
        addContact("src/contacts.txt", lines);
//        System.out.println(lines);
    }

    //=============================== TITLE MENU ===============================//
    @SuppressWarnings("all")
    public static void titleMenu(ArrayList<String> lines) {

        Scanner scan = new Scanner(System.in);
        System.out.println("1. View contacts");
        System.out.println("2. Add new contact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option");
        System.out.println("  ");
        System.out.println("=======================================================================================");
        System.out.println("  ");

        String option = scan.nextLine();
        if (option.equalsIgnoreCase("1")) {

            readList("src/contacts.txt", lines);
//            readList("src/contacts.txt", lines);

        } else if (option.equalsIgnoreCase("2")) {
            addContact("src/contacts.txt", lines);
        } else if (option.equalsIgnoreCase("3")) {
            searchForContact();
        } else if (option.equalsIgnoreCase("4")) {

        }

        System.out.println("Would you like to continue? [ yes | no ]");
        String userAnswer = scan.nextLine();
        if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")){
            titleMenu(lines);
        }else{
            System.out.println("Have a good day!");
        }
    }


    //  Collects name and contact information from contacts.txt
    public static ArrayList<String> readList(String contactPath, ArrayList<String> lines ) {
        Path contacts = Paths.get(contactPath);
//        List<String> lines = new ArrayList<>();
        try {
            lines = (ArrayList<String>) Files.readAllLines(contacts);
        } catch (IOException e ) {
            e.printStackTrace();
        }
        System.out.println("Name    | Phone number");
        System.out.println("-----------------------");

        for (String contact : lines) {
            System.out.println(contact);

        }
        System.out.println(" ");
//        addContact((ArrayList<String>) lines);       // Casting ArrayList to addContact method.         <--- might not need this comment.
        return lines;

    }


    public static ArrayList<String> addContact(String contactPath, ArrayList<String> lines) {
//        System.out.println(line);
        Scanner scan = new Scanner(System.in);

        Path contacts = Paths.get(contactPath);
//        List<String> lines = new ArrayList<>();
        try {
            lines = (ArrayList<String>) Files.readAllLines(contacts);

            System.out.println("What is your name?");
            String newContactName = scan.nextLine();
            System.out.println("What is your phone number?");
            String newContactNumber = scan.nextLine();
            Contact newContact = new Contact(newContactName,newContactNumber);
//        System.out.println(newContact.getAll());
            System.out.println("Original list " + lines);
            lines.add(newContact.getName() + " | " + newContact.getPhoneNumber());
            System.out.println("New list " + lines);
        } catch (IOException e ) {
            e.printStackTrace();
        }




//        OOPPractice newPerson = new OOPPractice(userFirstName, userLastName,userNickName, userFavColor, userAge);
//        PersonArrayList.add(newPerson);
        return lines;
    }

    public static void searchForContact() {

    }


    public static void deleteContact() {

    }

    public static void exit() {

    }





}
