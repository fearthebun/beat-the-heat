import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a list of records.
 *
 * @author Julia Xie
 * @version 1.11
 * <p>
 * 1.11 - Julia Xie
 * <br>Date: 2019/06/08
 * <br>Time Spent: 1 hour
 * <br>Added readRecord() method.
 * <br>Added clearRecords() method.
 * </p>
 * @since 1.11
 */
public class RecordsList {
    /**
     * Reads the records from a file into an ArrayList.
     *
     * @return the ArrayList of records.
     * @since 1.11
     */
    public static ArrayList<Record> readRecords() throws IOException{
            ArrayList<Record> arr = new ArrayList<>(0);
            Scanner in = new Scanner(new File("src/users.txt"));
            while (in.hasNextLine()) {
                String user = in.nextLine(); // gets the name of the user on this line
                //gets the contents of the file of that user
                Scanner temp = new Scanner(new File("src/Nayaab.txt"));

                String[] tokens = temp.nextLine().split(" ");
                int score = 0;
                for (String token : tokens)
                    try {
                        score += Integer.parseInt(token);
                    } catch (NumberFormatException e) {
                    }
                score *= 100; // multiply the score by 100

                arr.add(new Record(user, score));
            }
            return arr;
        }


    /**
     * Clears all the records from the file.
     *
     * @since 1.11
     */
    public static void clearRecords() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter("BeatTheHeat/src/Resources/users.txt"));
            out.close();
        } catch (IOException e) {
        }
    }
}