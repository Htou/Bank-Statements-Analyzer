import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankStatementsResources {
    private static final String RESOURCES = "src/resources.csv";

    public BankStatementsResources() {
    }

    public static String getRESOURCES() {

        return RESOURCES;
    }

}
