import java.time.Month;
import java.util.List;

public class BankStatementsAnalyzer {
    private BankStatementProcessor bankStatementProcessor;
    private List<BankTransaction> bankTransactions;

    BankStatementsAnalyzer() {
        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        BankStatementsResources resources = new BankStatementsResources();
        List<String> resourcesLinesList = resources.getResourcesLinesList();

        this.bankTransactions = bankStatementParser.parseLinesFromCSV(resourcesLinesList);
        this.bankStatementProcessor = new BankStatementProcessor(bankTransactions);
    }

    public void collectSummary() {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
