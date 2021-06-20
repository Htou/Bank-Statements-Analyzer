import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementsProcessor {

    final private List<BankTransaction> bankTransactions;

    BankStatementsProcessor() {
        final BankTransactionCSVParser bankStatementParser = new BankTransactionCSVParser();
        final BankStatementsResources resources = new BankStatementsResources();
        final List<String> resourcesLinesList = resources.getResourcesLinesList();

        this.bankTransactions = bankStatementParser.parseLinesFromCSV(resourcesLinesList);
    }

    private static double calculateTotalAmount(final List<BankTransaction> bankTransactions) {
        double total = 0d;

        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    private static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }

        return bankTransactionsInMonth;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;

        for(final BankTransaction bankTransaction: bankTransactions) {
            if(bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }
}
