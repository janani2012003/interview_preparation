import java.time.LocalDateTime;
import java.util.*;

class Transaction {
    String transactionId;
    String type;
    double amount;
    LocalDateTime dateTime;
    double balanceAfter;
    String details;

    public Transaction(String id, String type, double amount, double balanceAfter, String details) {
        this.transactionId = id;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
        this.details = details;
        this.dateTime = LocalDateTime.now();
    }
}

class Account {
    String accountId;
    String holderName;
    double balance;
    List<Transaction> transactions;

    public Account(String id, String name) {
        this.accountId = id;
        this.holderName = name;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }
}

public class BankingApp {

    private Map<String, Account> accounts = new LinkedHashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int transactionCounter = 1;

    private String generateTransactionId() {
        return "TXN" + (transactionCounter++);
    }

    public void createAccount() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        if (accounts.containsKey(id)) {
            System.out.println("Account already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        accounts.put(id, new Account(id, name));
        System.out.println("Account Created!");
    }

    public void deposit() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        acc.balance += amt;

        acc.transactions.add(new Transaction(
                generateTransactionId(),
                "DEPOSIT",
                amt,
                acc.balance,
                "Self Deposit"
        ));

        System.out.println("Deposited Successfully!");
    }

    public void withdraw() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        if (acc.balance < amt) {
            System.out.println("Insufficient Balance!");
            return;
        }

        acc.balance -= amt;

        acc.transactions.add(new Transaction(
                generateTransactionId(),
                "WITHDRAW",
                amt,
                acc.balance,
                "ATM Withdraw"
        ));

        System.out.println("Withdraw Successful!");
    }

    public void transfer() {
        System.out.print("From Account: ");
        String fromId = sc.nextLine();

        System.out.print("To Account: ");
        String toId = sc.nextLine();

        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        if (from == null || to == null) {
            System.out.println("Invalid account!");
            return;
        }

        System.out.print("Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        if (from.balance < amt) {
            System.out.println("Not enough balance!");
            return;
        }

        from.balance -= amt;
        to.balance += amt;

        from.transactions.add(new Transaction(
                generateTransactionId(),
                "TRANSFER OUT",
                amt,
                from.balance,
                "To " + to.holderName
        ));

        to.transactions.add(new Transaction(
                generateTransactionId(),
                "TRANSFER IN",
                amt,
                to.balance,
                "From " + from.holderName
        ));

        System.out.println("Transfer Done!");
    }

    public void showTransactions() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        if (acc.transactions.isEmpty()) {
            System.out.println("No Transactions!");
            return;
        }

        System.out.println("\nTRANSACTION HISTORY");
        for (Transaction t : acc.transactions) {
            System.out.println(
                    t.transactionId + " | " +
                            t.dateTime + " | " +
                            t.type + " | ₹" + t.amount +
                            " | Balance: ₹" + t.balanceAfter +
                            " | " + t.details
            );
        }
    }

    public void miniStatement() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found!");
            return;
        }

        int size = acc.transactions.size();
        System.out.println("\nMINI STATEMENT");

        for (int i = Math.max(0, size - 5); i < size; i++) {
            Transaction t = acc.transactions.get(i);
            System.out.println(t.type + " ₹" + t.amount + " | Balance: ₹" + t.balanceAfter);
        }
    }

    public void last10MembersHistory() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available!");
            return;
        }

        List<Account> list = new ArrayList<>(accounts.values());
        int size = list.size();

        System.out.println("\nLAST 10 MEMBERS HISTORY");

        for (int i = Math.max(0, size - 10); i < size; i++) {

            Account acc = list.get(i);

            System.out.println("\nAccount ID: " + acc.accountId);
            System.out.println("Name: " + acc.holderName);
            System.out.println("Balance: ₹" + acc.balance);

            if (acc.transactions.isEmpty()) {
                System.out.println("No Transactions");
            } else {
                for (Transaction t : acc.transactions) {
                    System.out.println(
                            t.transactionId + " | " +
                                    t.type + " | ₹" + t.amount +
                                    " | Balance: ₹" + t.balanceAfter
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        BankingApp app = new BankingApp();

        while (true) {
            System.out.println("\n1.Create 2.Deposit 3.Withdraw 4.Transfer 5.History 6.MiniStmt 7.Last10 8.Exit");
            System.out.print("Choice: ");

            int ch = Integer.parseInt(sc.nextLine());

            switch (ch) {
                case 1 -> app.createAccount();
                case 2 -> app.deposit();
                case 3 -> app.withdraw();
                case 4 -> app.transfer();
                case 5 -> app.showTransactions();
                case 6 -> app.miniStatement();
                case 7 -> app.last10MembersHistory();
                case 8 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}