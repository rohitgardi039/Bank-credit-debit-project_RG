package Banking.bo;

public class credit_bo
{
	private int id;
	private String date_time;
	private String amount;
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
	public credit_bo(int id, String date_time, String amount) {
		super();
		this.id = id;
		this.date_time = date_time;
		this.amount = amount;
	}
	public credit_bo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
