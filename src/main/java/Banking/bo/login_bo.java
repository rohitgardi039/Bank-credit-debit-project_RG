package Banking.bo;

public class login_bo
{
	
	private String account;
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public login_bo(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	
	

}
