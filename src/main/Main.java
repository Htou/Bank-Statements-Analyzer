package main;

public class Main {
    public static void main(final String... args) {
        final BankStatementAnalyzer bankStatementAnalyzer = new BankStatementAnalyzer();
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze(bankStatementParser);
    }
}
