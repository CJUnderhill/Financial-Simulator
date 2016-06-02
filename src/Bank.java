import java.util.HashMap;
import java.io.*;
import javax.swing.*;

public class Bank {

	private HashMap<String, Account> availableAccounts = new HashMap<String, Account>();
	private String accountFile = "accountinfo.txt";

	// Constructor
	public Bank() {
	}

	// Initialize bank info at program load
	public void initializeBank() {
		// Probably not the best way to do this
		// If file doesn't exist, create it
		if (!(new File(accountFile).exists())) {
			try {
				new File(accountFile).createNewFile();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Failed to create new file.");
			}
		}

		// Read file line by line
		try (BufferedReader br = new BufferedReader(new FileReader(accountFile))) {
			// For each line in accounts file
			for (String line = br.readLine(); line != null; line = br.readLine()) {
				// Split line info by spaces and add to accounts hashmap
				System.out.print(line);
				String[] split = line.split(" ");
				availableAccounts.put(split[0], new Account(split[0], split[1], Float.parseFloat(split[2])));
			}
			br.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Existing bank account info failed to read.");
		}
	}
	
	// Create new account
	public boolean createNewAccount(String acctNum, String acctPass) {
		// Check if account already exists
		if (availableAccounts.containsKey(acctNum)) {
			return false;
		} else {
			// Append info to file
			try (FileWriter fw = new FileWriter(accountFile, true)) {
				fw.write(acctNum + " " + acctPass + " 0.0" + System.lineSeparator());
				fw.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Failed to create new account.");
			}
			
			// Add account to HashMap of available accounts
			availableAccounts.put(acctNum, new Account(acctNum, acctPass, 0.0f));
			return true;
		}
	}
	
	// Update text file containing account info
	public void updateAccountsList(String acctNum, String acctPass, float value) {
		try (FileWriter fw = new FileWriter(accountFile, true)) {
			// Create new line and record updated account to text file
			fw.write(acctNum + " " + acctPass + " " + value + System.lineSeparator());
			fw.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Failed to create new account.");
		}
	}

	// Withdraw
	protected boolean withdrawFrom(String acctNum, String acctPass, float value) {
		Account acct = availableAccounts.get(acctNum);
		// Check that input password matches
		if (acct != null && acct.login(acctNum, acctPass)) {
			// Withdraw value from account
			float newval = acct.withdraw(value);
			availableAccounts.put(acctNum, acct);
			updateAccountsList(acctNum, acctPass, newval);
			return true;
		} else {
			return false;
		}
	}

	// Deposit
	protected boolean depositTo(String acctNum, String acctPass, float value) {
		Account acct = availableAccounts.get(acctNum);
		// Check that input password matches
		if (acct != null && acct.login(acctNum, acctPass)) {
			// Deposit value into account
			float newval = acct.deposit(value);
			availableAccounts.put(acctNum, acct);
			updateAccountsList(acctNum, acctPass, newval);
			return true;
		} else {
			return false;
		}
	}
}
