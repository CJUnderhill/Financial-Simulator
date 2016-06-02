import javax.swing.*;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Bank();
		b.initializeBank();
		System.out.println(b.createNewAccount("000000", "password"));
		System.out.println(b.createNewAccount("999999", "password2!"));
		b.depositTo("000000", "password", 100f);
		b.depositTo("000000", "asfda", 10000000000.5f);
		b.withdrawFrom("999999", "password2!", 10f);
		
		b.withdrawFrom("923829", "00293", 10000f);
		
		
		
		/* Testing Account Class *//*
		Account testAccount = new Account(0, "000000", "password");
		
		String acctNum;
		String acctPass;
		boolean acctAuth;
		
		acctNum = JOptionPane.showInputDialog("Enter account number");
		acctPass = JOptionPane.showInputDialog("Enter account password");
		 
		acctAuth = testAccount.login(acctNum, acctPass);
		
		if (acctAuth){
			JOptionPane.showMessageDialog(null, "Account authorized!");
		} else {
			JOptionPane.showMessageDialog(null, "Account not authorized. Please try again.");
		}

		JOptionPane.showMessageDialog(null, testAccount.getValue());
		testAccount.changeValue(200);
		JOptionPane.showMessageDialog(null, testAccount.getValue());
		testAccount.changeValue(-200);
		JOptionPane.showMessageDialog(null, testAccount.getValue());
		
		*//* End Testing */
		
		
	}

}
