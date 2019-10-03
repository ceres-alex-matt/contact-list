import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;


public class ContactsManager {

    public static void main(String[] args) {
        ArrayList<String> lines = new ArrayList<>(); // Create lines List
        titleMenu(lines);
//        readList("src/contacts.txt", lines);
//        addContact("src/contacts.txt", lines);
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
            continueApp(lines); // Ask user if they want to continue


        } else if (option.equalsIgnoreCase("2")) {
            addContact("src/contacts.txt", lines);
            continueApp(lines); // Ask user if they want to continue
        } else if (option.equalsIgnoreCase("3")) {
            searchForContact(lines, "src/contacts.txt");
            continueApp(lines); // Ask user if they want to continue
        } else if (option.equalsIgnoreCase("4")) {
            deleteContact(lines, "src/contacts.txt");
            continueApp(lines); // Ask user if they want to continue

        }else{
            System.out.println("Good bye");
        };


    }

    //======================================== DISPLAY LIST OF CONTACTS ========================================
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
        return lines;

    }

    //======================================== ADD A CONTACT ========================================
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
//            System.out.println("Original list " + lines);
            lines.add(newContact.getName() + " | " + newContact.getPhoneNumber());
//            System.out.println("New list " + lines);

//            Write array list to text file
            Path filepath = Paths.get("src", "contacts.txt");
            Files.write(filepath, lines);

            readList("src/contacts.txt", lines);


        } catch (IOException e ) {
            e.printStackTrace();
        }


        return lines;
    }

//======================================== SEARCH FOR A CONTACT ========================================//
    public static void searchForContact(ArrayList<String> lines, String contactPath) {
        Path contacts = Paths.get(contactPath);
        try {
            lines = (ArrayList<String>) Files.readAllLines(contacts);
            System.out.println(lines);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter the name you would like to search: ");
            String contactName = scan.nextLine();

            for(String d : lines){
                if(d.toLowerCase().contains(contactName.toLowerCase())) {
                    System.out.println(d);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //======================================== DELETE A CONTACT ========================================//
    public static void deleteContact(ArrayList<String> lines, String contactPath) {
        Scanner scan = new Scanner(System.in);
        Path contacts = Paths.get(contactPath);
        try {

            lines = (ArrayList<String>) Files.readAllLines(contacts);
            System.out.println("Who do you no longer like?");
            String oldContactName = scan.nextLine();
            for(String d : lines){
                if(d.toLowerCase().contains(oldContactName.toLowerCase())) {
                    System.out.println(d);
                    int indexNum = lines.indexOf(d);
                    System.out.println("index num " + indexNum);
//                    System.out.println(lines.remove(d));
                }
            }

            // Updating contacts.txt file.
//            Path filepath = Paths.get("src", "contacts.txt");
//            Files.write(filepath, lines);

            System.out.println(lines);

            //  lines.add(newContact.getName() + " | " + newContact.getPhoneNumber());
//            lines.remove(oldContactName + " | " + oldContact.getPhoneNumber())
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void exit() {

    }

    public static void continueApp(ArrayList<String> lines){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to continue? [ yes | no ]");
        String userAnswer = scan.nextLine();
        if (userAnswer.equalsIgnoreCase("yes") || userAnswer.equalsIgnoreCase("y")){
            titleMenu(lines);
        } else{
            System.out.println("Have a good day!");
        }
    }



}
