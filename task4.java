import java.util.Scanner;
import java.util.Stack;

class UserAccount
{
    static private int bank_balance;

    public static int getBank_balance() {
        return bank_balance;
    }

    public static void setBank_balance(int bank_balance) {
        UserAccount.bank_balance = bank_balance;
    }
}
class ATM_Machine
{
    Stack<String> transactionHistory = new Stack<>();
    static boolean flag = true;
    void displayMainMenu()
    {
        System.out.println("\n========================= ATM MENU =========================");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
        System.out.println("=============================================================");
    }
    void operations()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("OPERATION SELECTED : ");
        int operation = sc.nextInt();
        sc.nextLine();
        switch (operation)
        {
            case 1:
                System.out.println("\n========================= ACCOUNT BALANCE =========================");
                System.out.println("AVAILABLE BALANCE : "+UserAccount.getBank_balance()+" ₹");
                System.out.println("====================================================================");
                break;

            case 2:
                System.out.print("ENTER THE AMOUNT ₹ : ");
                int withdraw_amount = sc.nextInt();
                sc.nextLine();
                UserAccount.setBank_balance(UserAccount.getBank_balance()-withdraw_amount);
                transactionHistory.push("WITHDRAWAL AMOUNT : "+withdraw_amount+"₹");
                System.out.println("========================= WITHDRAWAL SUCCESSFUL =========================");
                break;

            case 3:
                System.out.print("ENTER THE AMOUNT ₹ : ");
                int deposit_amount = sc.nextInt();
                sc.nextLine();
                UserAccount.setBank_balance(UserAccount.getBank_balance()+deposit_amount);
                transactionHistory.push("DEPOSITED AMOUNT : "+deposit_amount+"₹");
                System.out.println("========================= DEPOSIT SUCCESSFUL =========================");
                break;

            case 4 :
               // recordTransaction();
                miniStatement();
                break;

            case 5:
                flag = false;
                System.out.println("\n");
                System.out.println("\n========================= APPLICATION CLOSING... =========================");
                break;

            default :
                System.out.println("PLEASE ENTER A VALID CHOICE !");
        }
    }

    private void miniStatement() {
        System.out.println("========================= MINI STATEMENT =========================");
        if(transactionHistory.size()<5)
        {
            for(String transaction : transactionHistory)
            {
                System.out.println(transaction);
            }
        }
        else
        {
            for(int i=1; i<=5; i++)
            {
                System.out.println(transactionHistory.pop());

            }
        }
            System.out.println("AVAILABLE BALANCE: " + UserAccount.getBank_balance()+"₹");

            System.out.println("\n===================================================================");
    }
}

class task4 extends ATM_Machine
{
    public static void main(String[] args)
    {
        System.out.println("========================= WELCOME TO ATM MACHINE =========================");
        task4 obj =  new task4();

        while(flag)
        {
            obj.displayMainMenu();
            obj.operations();
        }
    }
}
