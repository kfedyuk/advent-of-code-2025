import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ReaderUtil {

    public static List<String> readLines(String fileName) throws IOException {
        return  Files.readAllLines(Paths.get(fileName));
    }



}
