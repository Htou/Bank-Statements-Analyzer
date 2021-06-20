import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementsAnalyzer {

    private final List<BankTransaction> bankTransactions;

    BankStatementsAnalyzer() {

    }




    public void printAmount( ) {
        System.out.println("The total for all transactions is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " + selectInMonth(bankTransactions, Month.JANUARY));
    }

}
