import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private final BankStatementProcessor bankStatementProcessor;

    BankStatementAnalyzer() {
        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        BankStatementResources resources = new BankStatementResources();
        List<String> resourcesLinesList = resources.getResourcesLinesList();
        List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(resourcesLinesList);

        this.bankStatementProcessor = new BankStatementProcessor(bankTransactions);
    }

    public void collectSummary() {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
