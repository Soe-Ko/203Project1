import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLines {
    public static void thing(String[] args) {
        String filePath = "path/to/your/file.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line here
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}