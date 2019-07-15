package BlackRock;

public abstract class BankAccount {
	String currency;
	int units;
	BankAccount accountType;
	
	public abstract String getName();
	
	/**
	 * @return the accountType
	 */
	public BankAccount getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(BankAccount accountType) {
		this.accountType = accountType;
	}
	/**
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	/**
	 * @return the units
	 */
	public int getUnits() {
		return units;
	}
	/**
	 * @param units the units to set
	 */
	public void setUnits(int units) {
		this.units = units;
	}
	
	
	

}

class SavingsAccount extends BankAccount{
	public String getName(){
		return "Savings";
	}
	public SavingsAccount(String c,int u) {
		this.currency=c;
		this.units=u;
	}
	
	@Override
	public BankAccount getAccountType() {
		// TODO Auto-generated method stub
		return this;
	}
	
}

class CheckingAccount extends BankAccount{
	public String getName(){
		return "Checkings";
	}
	
	public CheckingAccount(String c,int u) {
		this.currency=c;
		this.units=u;
	}
	
	@Override
	public BankAccount getAccountType() {
		// TODO Auto-generated method stub
		return this;
	}
}

class BrokerageAccount extends BankAccount{
	public String getName(){
		return "Brokerage";
	}
	
	public BrokerageAccount(String c,int u) {
		this.currency=c;
		this.units=u;
	}
	
	@Override
	public BankAccount getAccountType() {
		// TODO Auto-generated method stub
		return this;
	}
}
