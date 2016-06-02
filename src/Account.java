
public class Account {

	private float value; // Value of account
	private String acctNum; // Account number
	private String acctPass; // Account password

	// Constructor
	protected Account(String acctNum, String acctPass, float value) {
		this.acctNum = acctNum;
		this.acctPass = acctPass;
		this.value = value;
	}

	// Takes account number and password and
	protected boolean login(String num, String pass) {
		// Check input against acctNum
		if (num.equals(this.acctNum)) {
			// Check input against acctPass
			if (pass.equals(this.acctPass)) {
				// Return true of input matches account details
				return true;
			}
		}
		return false;
	}

	// Withdraw from account
	protected float withdraw(float value) {
		this.setValue(this.getValue() - value);
		return this.getValue();
	}

	// Deposit into account
	protected float deposit(float value) {
		this.setValue(this.getValue() + value);
		return this.getValue();
	}

	// Getters/Setters for account number
	private String getNum() {
		return this.acctNum;
	}

	private void setNum(String acctNum) {
		this.acctNum = acctNum;
	}

	// Getters/Setters for account password
	private String getPass() {
		return this.acctPass;
	}

	private void setPass(String acctPass) {
		this.acctPass = acctPass;
	}

	// Getters/Setters for account value
	private float getValue() {
		return this.value;
	}

	private void setValue(float value) {
		this.value = value;
	}
}
