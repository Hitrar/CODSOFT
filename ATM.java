import java.util.Objects;
import java.util.Scanner;

public class ATM {
    private static final Scanner input = new Scanner(System.in);
    private static Account userAccount;
    public static void main(String[] Args){

        displayOptions();

    }
    public static void displayOptions(){
        System.out.println("*******ATM********");
        System.out.println("What do you want to do: ");
        System.out.println("0. Create an account");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check balance");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        handleChoice(input.next());
    }

    private static void handleChoice(String a) {
        if (Objects.equals(a, "0")){
            System.out.print("Enter Username: ");
            String username = input.next();
            System.out.print("Enter balance:");
            int balance = input.nextInt();
            createUserAccount(username, balance);
        }
        else if (Objects.equals(a, "4")){
            System.out.print("Exiting ... ByE");
        }
        else if (userAccount==null){
            System.out.println("Start by creating an account first ");
            displayOptions();
        }
        else if (Objects.equals(a, "1")){
            System.out.print("Enter Amount: ");
            int amount = input.nextInt();
            withdraw(amount);
        }
        else if (Objects.equals(a, "2")){
            System.out.print("Enter Amount: ");
            int amount = input.nextInt();
            deposit(amount);
        }
        else if (Objects.equals(a, "3")){
            System.out.println("Please wait... ");
            checkBalance();
        }

        else {
            System.out.println("Enter Valid option");
            displayOptions();
        }
    }
    private static void createUserAccount(String username, int balance) {
        userAccount = new Account(username, balance);
        System.out.println("User account created Successfully!!");
        displayOptions();
    }

    private static void checkBalance() {
        System.out.println(userAccount.getUsername()+"'s account balance is :"+userAccount.getBalance());

        displayOptions();
    }

    private static void deposit(int amount) {
        userAccount.setBalance(userAccount.getBalance()+amount);
        System.out.println("Deposit successful new balance is :" + userAccount.getBalance());
        displayOptions();
    }

    private static void withdraw(int amount) {
        if (userAccount.getBalance()-amount>0) {
            userAccount.setBalance(userAccount.getBalance()-amount);
            System.out.println("Withdrawal successful new balance is :" + userAccount.getBalance());
        }
        else
            System.out.println("Withdrawal Unsuccessful your balance is "+ userAccount.getBalance());
        displayOptions();
    }


}
class Account{
    private String username;
    private int balance;

    public Account(String username, int balance) {
        this.username = username;
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
