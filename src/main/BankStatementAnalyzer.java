package main;

import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {

    BankStatementAnalyzer() {
    }

    public void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("");
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total for transactions in March is " + bankStatementProcessor.calculateTotalInMonth(Month.MARCH));
        System.out.println("The total for transactions in April is " + bankStatementProcessor.calculateTotalInMonth(Month.APRIL));
        System.out.println("The total for transactions in May is " + bankStatementProcessor.calculateTotalInMonth(Month.MAY));
        System.out.println("The total for transactions in June is " + bankStatementProcessor.calculateTotalInMonth(Month.JUNE));
        System.out.println("The total for transactions in July is " + bankStatementProcessor.calculateTotalInMonth(Month.JULY));
        System.out.println("The total for transactions in August is " + bankStatementProcessor.calculateTotalInMonth(Month.AUGUST));
        System.out.println("The total for transactions in September is " + bankStatementProcessor.calculateTotalInMonth(Month.SEPTEMBER));
        System.out.println("The total for transactions in October is " + bankStatementProcessor.calculateTotalInMonth(Month.OCTOBER));
        System.out.println("The total for transactions in November is " + bankStatementProcessor.calculateTotalInMonth(Month.NOVEMBER));
        System.out.println("The total for transactions in December is " + bankStatementProcessor.calculateTotalInMonth(Month.DECEMBER));
        System.out.println("");
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total of highest transaction between Februari and July is " + bankStatementProcessor.calculateMaximumFromMonthsInRange(Month.FEBRUARY, Month.JULY));

    }

    public void analyze(final BankStatementParser bankStatementParser) {
        final List<String> lines = BankStatementResources.getResourcesLinesList();
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

}
