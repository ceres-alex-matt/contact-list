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


public class ContactsManager {

    public static void main(String[] args) {
        System.out.println(readList("src/contacts.txt"));
    }


    public static List<String> readList(String contactPath) {
        Path contacts = Paths.get(contactPath);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(contacts);
        } catch (IOException e ) {
        e.printStackTrace();
        }

//        System.out.println(lines);
        return lines;

    }


}
