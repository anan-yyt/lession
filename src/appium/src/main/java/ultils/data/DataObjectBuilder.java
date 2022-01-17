package ultils.data;
import com.google.gson.Gson;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
public class DataObjectBuilder {
    public static <T> T buildDataObject(String filePath, Class<T> dataType) {
        String absoluteFilePath = System.getProperty("user.dir").concat(filePath);

        try (
                Reader reader = Files.newBufferedReader(Paths.get(absoluteFilePath))
        ) {
            Gson g = new Gson();
            return g.fromJson(reader, dataType);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
