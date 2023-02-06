import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

class AccountDetails {
    byte accDetailsType;
    String accDetailsHolderName;
    Long accDetailsNumber;
    int accDetailsPassword;

    public AccountDetails(byte accType, String accHolderName, Long accNumber, int password) {
        this.accDetailsType = accType;
        this.accDetailsHolderName = accHolderName;
        this.accDetailsNumber = accNumber;
        this.accDetailsPassword = password;
    }
}

class Account {
    static List<AccountDetails> mainAccountDetails = new ArrayList<AccountDetails>();

    public Account(byte acctype, String accName, Long accNumberLong, int accPassword) {
        AccountDetails accountDetails = new AccountDetails(acctype, accName, accNumberLong, accPassword);
        mainAccountDetails.add(accountDetails);
    }

    final static void displayAccountsData() {
        System.out.println("all Accounts Details");
        for (AccountDetails aDetails : mainAccountDetails) {
            System.out.println("\nAccount Name: " + aDetails.accDetailsHolderName);
            System.out.println("Account Number: " + aDetails.accDetailsNumber);
            System.out.println("Account Password: " + aDetails.accDetailsPassword);
            System.out.println("Account Type: " + aDetails.accDetailsType);
        }
    }
}

class CurrentAccount extends Account {

    public CurrentAccount(byte acctype, String accName, Long accNumberLong, int accPassword) {
        super(acctype, accName, accNumberLong, accPassword);

    }
}

class SavingAccount extends Account {

    public SavingAccount(byte acctype, String accName, Long accNumberLong, int accPassword) {
        super(acctype, accName, accNumberLong, accPassword);

    }
}

class Bank {

    static byte myAccType;
    static String myAccName;
    static Long myAccNumLong;
    static int myAccPassword;

    public static void main(String[] args) {
        System.out.println("\nWelcome to our Banking System");
        aboutAccount();

    }

    static void aboutAccount() {
        System.out.println("\nInfo:   press 1 to Create an Account");
        System.out.println("Info:   press 2 to go to an Existing Account");
        System.out.println("Want to create an Account or have one??");

        Scanner account_picker = new Scanner(System.in);
        byte ans_of_account_picker = account_picker.nextByte();

        byte accType = 0;

        switch (ans_of_account_picker) {
            case 1:
                accType = typeOfAccount();
                fetchDetails(accType);
                break;
            case 2:
                accType = typeOfAccount();
                fetchDetails(accType);
                break;
            default:
                System.out.println("Please Enter Correct value...");
        }
    }

    static byte typeOfAccount() {
        System.out.println("\nInfo:   press 1 for Saving Account");
        System.out.println("Info:   press 2 for Current Account");
        System.out.println("Select the type of Account??");

        Scanner account_type_picker = new Scanner(System.in);
        byte ans_of_account_type_picker = account_type_picker.nextByte();

        byte accType2 = 0;

        switch (ans_of_account_type_picker) {
            case 1:
                accType2 = 1;
                break;
            case 2:
                accType2 = 2;
                break;
            default:
                System.out.println("Please Enter Correct value...");
        }
        return accType2;
    }

    static void fetchDetails(byte accType3) {
        myAccType = accType3;

        ThreadLocalRandom random = ThreadLocalRandom.current();
        myAccNumLong = random.nextLong(10_000_000_000L, 100_000_000_000L);
        // myAccNumLong = 1234567890L;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        myAccName = sc.next();
        int len = 4;
        do {
            if (len != 4) {
                System.out.println("Please Enter 4 Digit Password");
            }
            System.out.println("Enter your Password: ");
            myAccPassword = sc.nextInt();

            len = String.valueOf(myAccPassword).length();
        } while (len != 4);

        System.out.println("\nYour Account is Created & it's Details are given below");
        System.out.println("\nAccount holder Name: " + myAccName);
        System.out.println("Account Number: " + myAccNumLong);
        System.out.println("Account Password:" + myAccPassword);

        if (myAccType == 1) {
            System.out.println("Type of Account: Saving\n");
            SavingAccount savingAccount = new SavingAccount(myAccType, myAccName, myAccNumLong, myAccPassword);
            // Account.displayAccountsData();
            aboutAccount();
        } else {
            System.out.println("Type of Account: Current\n");
            CurrentAccount currentAccount = new CurrentAccount(myAccType, myAccName, myAccNumLong, myAccPassword);
            // Account.displayAccountsData();
            aboutAccount();
        }
    }
}