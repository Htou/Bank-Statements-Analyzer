package main;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
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

    public double calculateMaximumFromMonthsInRange(final Month firstMonth, final Month lastMonth) {
        double total = 0;

        LocalDate startDate = LocalDate.of(2020, firstMonth, firstMonth.minLength());
        LocalDate endDate = LocalDate.of(2020, lastMonth, lastMonth.maxLength());

        for (final BankTransaction bankTransaction : bankTransactions) {
            LocalDate bankTransactionDate = bankTransaction.getDate();

            if (bankTransactionDate.isAfter(startDate) && bankTransactionDate.isBefore(endDate)) {
                total += bankTransaction.getAmount();
            }

        }

        return total;
    }
}