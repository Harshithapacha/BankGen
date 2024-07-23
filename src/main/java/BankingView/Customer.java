package BankingView;

public class Customer {
    private String accountNo;
    private String fullName;
    private String emailId;
    private String mobileNo;
    private String address;
    private String accountType;
    private String dob;
    private String idProof;
    private double balance;
    private String username;

 

    public Customer(String accountNo, String fullName, String emailId, String mobileNo, String address, String accountType, String dob, String idProof) {
        this.accountNo = accountNo;
        this.fullName = fullName;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
        this.address = address;
        this.accountType = accountType;
        this.dob = dob;
        this.idProof = idProof;   
    }
	public Customer() {
		String accountNo;
	    String fullName;
	    String emailId;
	    String mobileNo;
	    String address;
	  String accountType;
	     String dob;
	   String idProof;
	   double balance;
	     String username;

	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	// Getters and setters
    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getIdProof() {
        return idProof;
    }

    public void setIdProof(String idProof) {
        this.idProof = idProof;
    }

   
    
}
