import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactions {
    private static final String RESOURCES = "src/resources.csv";

    public BankTransactions() {
    }

    public static String getRESOURCES() {
        return RESOURCES;
    }
}
