import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class read {
    public void readfile (Path path) {
        try {
            byte[] array = Files.readAllBytes(path);

            String content = new String(array, "UTF-8");
            System.out.println(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
