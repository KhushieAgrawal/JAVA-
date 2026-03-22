import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<customer> customers = new ArrayList<>();

        customer c1 = new customer("092", "Khushie", "Agrawal", "khushi1805@gmail.com",
                "99813123", "Pune", "375938281", "AHDJWU2");

        customer c2 = new customer("086", "Adele", "Singh", "adele12@gmail.com",
                "9876543210", "Bhopal", "4838939428", "JAJDNWNIRN");

        customer c3 = new customer("087", "Nikki", "Sharma", "nikki28@gmail.com",
                "4938289194", "Delhi", "1938218384", "JWUNRBTHNUBF");

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        ArrayList<Account> accounts = new ArrayList<>();

        SavingsAccount sa1 = new SavingsAccount(1001, 6000, c1);
        CurrentAccount ca1 = new CurrentAccount(2001, 20000, c1);
        accounts.add(sa1);
        accounts.add(ca1);

        SavingsAccount sa2 = new SavingsAccount(1002, 8000, c2);
        CurrentAccount ca2 = new CurrentAccount(2002, 17000, c2);
        accounts.add(sa2);
        accounts.add(ca2);

        SavingsAccount sa3 = new SavingsAccount(1003, 4000, c3);
        accounts.add(sa3);

        // ── SECTION 1: Normal Transactions ──
        System.out.println("\n  Performing Transactions\n");
        try {
            sa1.deposit(2000);
            sa1.withdraw(1000);
            sa1.calculateInterest();
            System.out.println();

            Loan loan = new Loan(12000, 12);
            loan.displayLoan();
            loan.payEMI(sa1);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // ── SECTION 2: Customer and Account Summary ──
        System.out.println("\nCustomer and Account summary:\n");
        displayInfo(customers, accounts);

        // ── SECTION 3: Exception - Not enough balance to pay EMI ──
        System.out.println("\n  Performing Transactions\n");
        try {
            SavingsAccount tempSa = new SavingsAccount(1001, 6000, c1);
            tempSa.deposit(2000);
            tempSa.withdraw(1000);
            tempSa.calculateInterest();
            System.out.println();

            Loan loan = new Loan(5552000, 12);
            loan.displayLoan();
            loan.payEMI(tempSa);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        // ── SECTION 4: Exception - Minimum balance 500 required ──
        System.out.println("\n  Performing Transactions\n");
        try {
            SavingsAccount tempSa2 = new SavingsAccount(1001, 6000, c1);
            tempSa2.withdraw(5600);

        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public static void displayInfo(ArrayList<customer> customers, ArrayList<Account> accounts) {
        for (customer cust : customers) {
            System.out.println("---- CUSTOMER DETAILS ----");
            cust.displayCustomer();

            System.out.println("\n---- ACCOUNTS ----");
            double totalBalance = 0;
            int accountCount = 0;

            for (Account acc : accounts) {
                if (acc.customer.customerID.equals(cust.customerID)) {
                    System.out.println("Account Number: " + acc.accountNumber);
                    System.out.println("Account Type: " + acc.getClass().getSimpleName());
                    System.out.println("Balance: Rs. " + acc.balance);
                    totalBalance += acc.balance;
                    accountCount++;
                    System.out.println();
                }
            }

            if (accountCount > 0) {
                System.out.println("Total Accounts: " + accountCount);
                System.out.println("Total Balance Across All Accounts: Rs. " + totalBalance);
            } else {
                System.out.println("No accounts found for this customer.");
            }
            System.out.println();
        }
    }
}