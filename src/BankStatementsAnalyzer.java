
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
    private final BankTransactionCSVParser bankStatementParser;
    private final BankStatementsResources resources;
    private final List<String> resourcesLinesList;
    private final List<BankTransaction> bankTransactions;

    BankStatementsAnalyzer() {
        this.bankStatementParser = new BankTransactionCSVParser();
        this.resources = new BankStatementsResources();
        this.resourcesLinesList = resources.getResourcesLinesList();
        this.bankTransactions = bankStatementParser.parseLinesFromCSV(resourcesLinesList);
    }

    public void calculateTotal() {
        System.out.println("The total for all transactions is " + this.bankTransactions);
    }

//    public void calculateTotalt() {
//        List<String> lines =  resources.getResourcesLinesList();
//
//        double total = 0d;
//
//        for (final String line : lines) {
//            final String[] columns = line.split(",");
//            final double amount = Double.parseDouble(columns[1]);
//
//            total += amount;
//        }
//
//        System.out.println("The total for all transactions is " + total);
//    }
//
//    public void calculateSumJanuary() {
//        List<String> lines = resources.getResourcesLinesList();
//
//        double total = 0d;
//        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        for (final String line : lines) {
//            final String[] columns = line.split(",");
//            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
//
//            if (date.getMonth() == Month.JANUARY) {
//                final double amount = Double.parseDouble(columns[1]);
//
//                total += amount;
//            }
//        }
//
//        System.out.println("The total for all transactions in January: " + total);
//    }


}
