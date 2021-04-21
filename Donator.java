import java.util.*;
class Government{
	String donatorName;
	long donatorPhoneNumber;
	private static int totalPMFund = 0;
	private static int totalCMFund = 0;
	Scanner sc = new Scanner(System.in);
	
	protected final void setPMFund(int amount) {
		System.out.print("Enter Name: ");
		donatorName = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		donatorPhoneNumber = sc.nextLong();
		totalPMFund = totalPMFund + amount;
	}
	
	protected final void setCMFund(int amount) {
		System.out.print("Enter Name: ");
		donatorName = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		donatorPhoneNumber = sc.nextLong();
		totalCMFund = totalCMFund + amount;
	}
	
	protected final void getTotalPMFund() {
		System.out.println("Total PM Fund = "+totalPMFund);
	}
	
	protected final void getTotalCMFund() {
		System.out.println("Total CM Fund = "+totalCMFund);
	}
	
	protected final void printReceipt(String typeOfFund, int amount) {
		System.out.println("--Receipt--");
		System.out.println("Name: "+donatorName);
		System.out.println("Phone Number: "+donatorPhoneNumber);
		System.out.println("Amount Donated: "+amount);
		System.out.println("Type of Fund: "+typeOfFund);
	}
}
public class Donator extends NGO{
	Scanner sc = new Scanner(System.in);
	void donate(int typeOfFund, int amount) {
		switch(typeOfFund) {
		case 1:
			NGO ob1 = new NGO();
			ob1.setPMFund(amount);
			ob1.printReceipt("PM Fund", amount);
			break;
			
		case 2:
			NGO ob2 = new NGO();
			ob2.setCMFund(amount);
			ob2.printReceipt("CM Fund", amount);
			break;
			
		case 3:
			NGO ob4 = new NGO();
			ob4.setHelpFund(amount);
			ob4.printReceipt("Help Fund", amount);
			break;
			
		case 4:
			NGO ob3 = new NGO();
			System.out.println("1.Total PM Fund\t2.Total CM Fund\t3.Total Help Fund\t4.No");
			int choice = sc.nextInt();
			if(choice == 1) {
				ob3.getTotalPMFund();
			}
			else if(choice == 2) {
				ob3.getTotalCMFund();
			}
			else if(choice == 3) {
				ob3.getTotalHelpFund();
			}
			else if(choice == 4) {
				System.exit(0);
			}
			break;
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Donator[] obj = new Donator[100];
		for(int i=0; i<100; i++){
			int choice, amount;
			obj[i] = new Donator();
			System.out.println("Choose Which Fund you want to Support: ");
			System.out.println("1.PM Fund 2.CM Fund 3.Help Fund 4.Details 9.Exit");
			choice = sc.nextInt();
			try {
				System.out.print("Enter Amount: ");
				amount = sc.nextInt();
				if(amount <= 0) {
					throw new MyException1();
				}
				else {
					obj[i].donate(choice, amount);
				}
			}
			catch(MyException1 e) {
				System.out.println(e.toString());
			}
		}
	}
}
class NGO extends Government{
	protected static int totalHelpFund = 0;
		
	protected final void setHelpFund(int amount) {
		System.out.print("Enter Name: ");
		donatorName = sc.nextLine();
		System.out.print("Enter Phone Number: ");
		donatorPhoneNumber = sc.nextLong();
		totalHelpFund = totalHelpFund + amount;
	}
	
	protected final void getTotalHelpFund() {
		System.out.println("Total Help Fund = "+totalHelpFund);
	}
}
class MyException1 extends Exception {
	public String toString() {
		return "MidTem2. InvalidException Please Donate Amount greater than 0";
	}
}