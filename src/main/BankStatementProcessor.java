package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {

            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {

            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }

        return total;
    }

    public double calculateTotalAmount() {
        double total = 0;

        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }

        return total;
    }

    public double calculateMaximumFromRange(final Month firstMonth, final Month lastMonth) {
        ArrayList<Double> transactionsInRange = new ArrayList<Double>();

        LocalDate startDate = LocalDate.of(2020, firstMonth, 1);
        LocalDate endDate = LocalDate.of(2020, lastMonth, lastMonth.maxLength());

        for (final BankTransaction bankTransaction : bankTransactions) {
            LocalDate bankTransactionDate = bankTransaction.getDate();

            if (bankTransactionDate.isAfter(startDate) && bankTransactionDate.isBefore(endDate)) {
                transactionsInRange.add(bankTransaction.getAmount());
            }

        }

        double total = Collections.max(transactionsInRange);

        return total;
    }

    public ArrayList<Double> calculateMaximumOfEachMonthInRange(final Month firstMonth, final Month lastMonth) {
        ArrayList<Double> maximumTransactionOfEachMonth = new ArrayList<Double>();

        LocalDate startDate = LocalDate.of(2020, firstMonth, 1);
        LocalDate endDate = LocalDate.of(2020, lastMonth, lastMonth.maxLength());


        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusMonths(1)) {
            Month startOfMonth = date.getMonth();
            Month endOfMonth = date.getMonth();

            maximumTransactionOfEachMonth.add(calculateMaximumFromRange(startOfMonth, endOfMonth));
        }

        return maximumTransactionOfEachMonth;
    }
}