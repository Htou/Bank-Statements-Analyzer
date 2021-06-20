
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

public class BankStatementsAnalyzer {

    public List<String> getResourcesLinesList() {
        try {
            String RESOURCES = BankStatementsResources.getRESOURCES();
            final Path path = Paths.get(RESOURCES);
            final List<String> lines = Files.readAllLines(path);

            return lines;

        } catch (IOException e) {
            System.out.println("Error, file not found");

            return Collections.<String>emptyList();
        }
    }


    public void calculateTotal() {
        List<String> lines = getResourcesLinesList();

        double total = 0d;

        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);

            total += amount;
        }

        System.out.println("The total for all transactions is " + total);
    }

    public void calculateSumJanuary() {
        List<String> lines = getResourcesLinesList();

        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (final String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);

            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);

                total += amount;
            }
        }

        System.out.println("The total for all transactions in January: " + total);
    }

}
