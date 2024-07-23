package BankingView;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private int transactionId;
    private String accountNo;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String transactionType;

    public Transaction(int transactionId, String accountNo, BigDecimal amount, LocalDateTime timestamp, String transactionType) {
        this.transactionId = transactionId;
        this.accountNo = accountNo;
        this.amount = amount;
        this.timestamp = timestamp;
        this.transactionType = transactionType;
    }

    

	public Transaction(int transactionId2, String accNo, double amount2, LocalDateTime timestamp2) {
		// TODO Auto-generated constructor stub
	}



	public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }
}
