package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReadData {
    
    public static List<String> readFromCsv(String path) {
        List<String> data = null;
        try {
            data = Files.readAllLines(new File(path).toPath());    
        } catch (IOException e) {
            System.out.println("Error - File not found");
            e.printStackTrace();
        }
        return data;
    }
}
