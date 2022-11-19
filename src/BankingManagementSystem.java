import java.io.FileInputStream;
import java.util.Scanner;

public class BankingManagementSystem {
	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Vighnesh Gadge ", "25");
		obj.showMenu();
	}
}

class BankAccount{
	int balance;
	int previousTransaction;
	String customerName;
	String customerId;
	
	String fname;
	String lname;
	String username ;
	int pin;
	
	void CreateAccount(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the First Name : ");
		fname = sc.nextLine();
		
		System.out.print("Enter The Last Name : ");
		lname  = sc.nextLine();
		
		System.out.print("Enter the Username : ");
		username  = sc.nextLine();
		
		System.out.println("Enter The PIN : ");
		pin = sc.nextInt();
		
		
		
	}
	BankAccount(String cname, String cid){
		customerName = cname;
		customerId = cid;
		
	}
	
	void deposit(int amount) {
		if(amount != 0) 
		{
			balance = balance + amount;
			previousTransaction = amount;
		}
	}
	
	void withdraw(int amount ) {
		if(amount != 0) 
		{
			balance = balance - amount;
			previousTransaction = -amount;
		}
	}
	
	void getPreviousTransaction() {
		if(previousTransaction > 0) 
		{
			System.out.println("Deposited : "+previousTransaction);
		}else if(previousTransaction < 0)
		{
			System.out.println("withdraw : "+Math.abs(previousTransaction));
		}else 
		{
			System.out.println("No transaction occured");
		}
	}
	
	void showMenu() 
	{
		char option = '\0';
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcome "+customerName );
		System.out.println("Your ID is "+customerId);
		System.out.println("\n");
		System.out.println("A. Check Balance ");
		System.out.println("B. Deposit ");
		System.out.println("C. Withdraw ");
		System.out.println("D. Previous Transaction ");
		System.out.println("E. Exit ");
		
		do {
			System.out.println("====================================================");
			System.out.println("Enter an Option : ");
			System.out.println("====================================================");
			option =  sc.next().charAt(0);
			System.out.println("\n");
			
			switch(option) {
			
			case 'A' : 
				System.out.println("--------------------------------------------------");
				System.out.println("Balance = "+balance);
				System.out.println("--------------------------------------------------");
				System.out.println("\n");
				break;
				
			case 'B' : 
				System.out.println("--------------------------------------------------");
				System.out.println("Enter an amount to deposit : ");
				System.out.println("--------------------------------------------------");
				int  amount = sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;
				
			case 'C' :
				System.out.println("---------------------------------------------------");
				System.out.println("Enter an amount to withdraw : ");
				System.out.println("---------------------------------------------------");
				int amount2  =sc.nextInt();
				withdraw(amount2);
				System.out.println("\n");
				break;
				
			case 'D' : 
				System.out.println("---------------------------------------------------");
				getPreviousTransaction();
				System.out.println("---------------------------------------------------");
				System.out.println("\n");
				
				
			case 'E' :
				System.out.println("====================================================");
				break;
				default :
					System.out.println("Invalid Option!. Please Enter Again ");
					break;
			}
			
		}while(option != 'E');
		System.out.println("Thank You For Using Our Services ");
	}
}
