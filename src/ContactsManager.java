package fileIO;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ContactsManager {

    public static void main(String[] args) {
        titleMenu();
        readList("src/contacts.txt");

    }

    //=============================== TITLE MENU ===============================//
    public static void titleMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. View contacts");
        System.out.println("2. Add new ocntact");
        System.out.println("3. Search a contact by name");
        System.out.println("4. Delete an existing contact");
        System.out.println("5. Exit");
        System.out.println("Enter an option");
        System.out.println("  ");
        System.out.println("=======================================================================================");
        System.out.println("  ");

        String option = scan.nextLine();
        if (option.equalsIgnoreCase("1")) {
            readList("src/contacts.txt\n");
        } else if (option.equalsIgnoreCase(2)) {
            addContact();
        } else if (option.equalsIgnoreCase("3")) {
            searchForContact();
        } else if (option)
    }


    //  Collects name and contact information from contacts.txt
    public static List<String> readList(String contactPath) {
        Path contacts = Paths.get(contactPath);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(contacts);
        } catch (IOException e ) {
        e.printStackTrace();
        }
            System.out.println("Name    | Phone number");
            System.out.println("-----------------------");

        for (String contact : lines) {
            System.out.println(contact);
        }
        addContact((ArrayList<String>) lines);       // Casting ArrayList to addContact method.         <--- might not need this comment.
        return lines;

    }


    public static ArrayList<String> addContact(ArrayList<String> line) {
        System.out.println(line);
        return line;
    }

    public static void searchForContact() {

    }


    public static void deleteContact() {

    }

    public static void exit() {

    }





}
