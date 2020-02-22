package postgressql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;

public class File {

    public static String[] readFile() throws Exception {
        JdbcConnection jc = new JdbcConnection();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/home/nafees/file.csv"));
            String line = reader.readLine();
            while (line != null) {
                String[] lineRead = line.split(",");
                jc.dataInsert(lineRead);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
