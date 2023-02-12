package Banking.bo;

public class debit_bo
{
	private int id;
	private String date_time;
	private String amount;
	private String type;
	private String Balance;
	
	
	public void setBalance(String balance) {
		Balance = balance;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate_time() {
		return date_time;
	}
	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public debit_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getBalance() {
		// TODO Auto-generated method stub
		return Balance;
	}
	
	

}
