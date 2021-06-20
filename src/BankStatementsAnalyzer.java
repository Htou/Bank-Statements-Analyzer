import java.time.Month;
import java.util.ArrayList;
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

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;

        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }

        return bankTransactionsInMonth;
    }


    public void printAmount( ) {
        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

}
