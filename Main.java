package Project_02_Banking;
import java.util.*;
class Bank{
    int accountNo;
    String name;
    double amount;
    Bank(int accountNo, String name, double amount){
        this.accountNo = accountNo;
        this.name = name;
        this.amount = amount;
    }
}
public class Main {
    static void main() {
        Scanner sc = new Scanner(System.in);
        ArrayList <Bank> bank = new ArrayList<>();
        bank.add(new Bank(12345, "Peter Parker", 25000.00));
        int choice;
        boolean nStatus = false;
        do{
            System.out.print("Enter your choice\n1. Open Account\n2. Withdraw\n3. Deposite\n4. Account Detail\n5. Delete Account\n6.Exit: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Account number: ");
                    int no = sc.nextInt();
                    for(int i=0; i<bank.size(); i++){
                        if(bank.get(i).accountNo == no){
                            System.out.println("This account number is occupied please choose another one");
                            nStatus = false;
                            break;
                        }
                        else{
                            nStatus = true;
                        }
                    }
                    if(nStatus){
                        System.out.print("Enter your name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Enter amount to deposit: ");
                        double amount = sc.nextDouble();
                        bank.add(new Bank(no, name, amount));
                        System.out.println("Account created Successfully");
                    }
                    break;
                case 2:
                    System.out.print("Enter your account number: ");
                    no = sc.nextInt();
                    for(int i=0; i<bank.size(); i++){
                        if(bank.get(i).accountNo == no){
                            System.out.print("Enter amount to Withdraw: ");
                            double withdraw = sc.nextDouble();
                            if(bank.get(i).amount < withdraw){
                                System.out.println("Insufficient amount");
                            }
                            else{
                                bank.get(i).amount = bank.get(i).amount - withdraw;
                                System.out.println("Amount withdraw Successfully");
                            }
                            nStatus = true;
                            break;
                        }
                        else{
                            nStatus = false;
                        }
                    }
                    if(!nStatus) System.out.println("Invalid account number");
                    break;
                case 3:
                    System.out.print("Enter your account number: ");
                    no = sc.nextInt();
                    for(int i=0; i<bank.size(); i++){
                        if(bank.get(i).accountNo == no){
                            System.out.print("Enter amount to Deposit: ");
                            double deposit = sc.nextDouble();
                            bank.get(i).amount = bank.get(i).amount + deposit;
                            System.out.println("Amount deposit Successfully");
                            nStatus = true;
                            break;
                        }
                        else{
                            nStatus = false;
                        }
                    }
                    if(!nStatus) System.out.println("Invalid account number");
                    break;
                case 4:
                    System.out.print("Enter your account number: ");
                    no = sc.nextInt();
                    for(int i=0; i<bank.size(); i++){
                        if(bank.get(i).accountNo == no){
                            System.out.println("Account Number: "+bank.get(i).accountNo+"\nAccount Holder Name: "+bank.get(i).name+"\nAmount in account: "+bank.get(i).amount);
                            nStatus = true;
                            break;
                        }
                        else{
                            nStatus = false;
                        }
                    }
                    if(!nStatus) System.out.println("Invalid account number");
                    break;
                case 5:
                    System.out.print("Enter your account number: ");
                    no = sc.nextInt();
                    for(int i=0; i<bank.size(); i++){
                        if(bank.get(i).accountNo == no){
                            bank.remove(i);
                            System.out.println("Account Deleted Successfully");
                            nStatus = true;
                            break;
                        }
                        else{
                            nStatus = false;
                        }
                    }
                    if(!nStatus) System.out.println("Invalid account number");
                    break;
                case 6:
                    System.out.println("Thanks for visiting");
                    break;
                default:
                    System.out.println("Enter a valid Choice");
            }
        }while(choice!=6);
    }
}