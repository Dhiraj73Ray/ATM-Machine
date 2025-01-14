import java.util.Scanner;

class ATM{

    float Balance = 100;
    int PIN = 2020;


    ATM(){
        System.out.println("Enter your Pin");
    }

    public void checkPin(){
        Scanner sc = new Scanner(System.in);
        int enteredPIN = sc.nextInt();

        if (enteredPIN == PIN){
            menu();
        }
        else {
            System.out.print("Invalid Pin\n");
            checkPin();
        }
    }

    public void  menu(){
        System.out.printf("Enter Your Choice:\n");
        System.out.printf("1. Check Your A/C Balance\n");
        System.out.printf("2. Deposit Money:\n");
        System.out.printf("3. Withdraw Money:\n");
        System.out.printf("4. Exit:\n");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        if (option == 1){
            checkBalance();
        } else if (option == 2) {
            deposit();
        } else if (option ==3) {
            withdraw();
        } else if (option == 4) {
            System.out.println("Have A Nice Day");
//            break;
        }
        else {
            System.out.println("Invalid Choice\n");
            menu();
        }
    }

    public void checkBalance(){
        System.out.println("Your current Balance: " + Balance);
        menu();
    }

    public void deposit(){
        System.out.printf("Enter the amount you want to deposit: ");
        Scanner sc = new Scanner(System.in);
        float enterMoney = sc.nextInt();
        Balance = Balance + enterMoney;
        System.out.println(enterMoney + " money has been Credited to your Account successfully\n" +
                "Total A/C Balance " + Balance);
        menu();
    }

    public void withdraw(){
        System.out.printf("Enter the amount you want to withdraw: ");
        Scanner sc = new Scanner(System.in);
        int enterMoney = sc.nextInt();
        if(enterMoney > Balance){
            System.out.println("Insufficient Balance in A/C");
        }
        else {
            Balance = Balance - enterMoney;
            System.out.println(enterMoney + " money has been Debited from your Account\n" +
                    "Total A/C Balance " + Balance);
        }

        menu();
    }
}

public class ATMMachine {
    public static void main(String[] args) {
        System.out.println("Welcome to ATM Machine");
        ATM atm = new ATM();
        atm.checkPin();
    }
}