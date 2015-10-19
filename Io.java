import java.nio.file.*;
import java.util.function.*;

public class Io {
    public static void main(String[] args) throws Exception {
        readWrite();
        walk(Paths.get(".."), System.out::println);
    }

    public static void walk(Path path, Consumer<String> visitor) {
        if (Files.isRegularFile(path)) {
            visitor.accept(path.toString());
        } else if (Files.isDirectory(path)) {
            try {
                Files.list(path).forEach(p -> walk(p, visitor));
            } catch (Exception e) { /* ignored */ }
        } else /* symbolic links, pipes and other types of paths */ {
            /* ignored */
        }
    }

    private static void readWrite() throws Exception {
        Path path = Paths.get("sandro.out");
        String data = "sandro";
        Files.write(path, data.getBytes());
        System.out.println(new String(Files.readAllBytes(path)).equals(data));
    }
}
