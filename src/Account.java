
public class Account {

	private float value;		// Value of account
	private String acctNum;		// Account number
	private String acctPass;	// Account password
	
	// This is set up so that all valid accounts must first be initialized in code
	//	(or can be imported from a file/database)
	Account(float value, String acctNum, String acctPass){
		this.value = value;
		this.acctNum = acctNum;
		this.acctPass = acctPass;
	}
	
	// Takes account number and password and 
	boolean login(String num, String pass) {
		// Check input against acctNum
		if(num.equals(this.acctNum)) {
			// Check input against acctPass
			if(pass.equals(this.acctPass)) {
				// Return true of input matches account details
				return true;
			}
		}
		return false;
	}
	
	// Getters/Setters for account value
	float getValue() {
		return this.value;
	}
	private void setValue(float value) {
		this.value = value;
	}
	void changeValue(float value) {
		this.setValue(this.getValue() + value);
	}
}
