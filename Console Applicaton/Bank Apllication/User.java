package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
	private String name, email,  phone, gender, passWord, ifsc;
	private byte age;
	private double balance, loanEligibilityAmount;
	private long acNumber;
	private boolean loanFlag, accountBlock;
	private int cibil;
	
	
	User(String name, String email,String phone,String gender,String passWord,byte age,double balance,String ifsc, long acno, int cibil, boolean flag, boolean accountBlock){
		this.name=name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.passWord = passWord;
		this.balance = balance;
		this.acNumber = acno;
		this.ifsc = ifsc;
		this.cibil=cibil;
	    this.loanFlag = flag;
	    this.accountBlock = accountBlock;
		
	}

	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double tempMoney) {
		this.balance = tempMoney;
		setLoanEligibilityAmount(tempMoney/50);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAcNumber() {
		return acNumber;
	}

	public void setAcNumber(long acNumber) {
		this.acNumber = acNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getIfsc() {
		return ifsc;
	}


	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}
	
	public String toString() {
		return ("\n---------------------------"+"\n     Account Information "+
		"\n---------------------------"+
		"\n    Name     :"+getName()+
		"\n    Email    :"+getEmail()+
		"\n    A/C No   :"+getAcNumber()+
		"\n    IFSC     :"+getIfsc()+
		"\n    Balance  :"+getBalance()+
		"\n---------------------------");
		
		
		
	}


	public boolean isLoanFlag() {
		return loanFlag;
	}


	public void setLoanFlag(boolean loanFlag) {
		this.loanFlag = loanFlag;
	}


	public boolean isAccountBlock() {
		return accountBlock;
	}


	public void setAccountBlock(boolean accountBlock) {
		this.accountBlock = accountBlock;
	}


	public int getCibil() {
		return cibil;
	}


	public void setCibil(int cibil) {
		this.cibil = cibil;
	}


	public double getLoanEligibilityAmount() {
		return loanEligibilityAmount;
	}


	public void setLoanEligibilityAmount(double loanEligibilityAmount) {
		this.loanEligibilityAmount += loanEligibilityAmount;
	}



}
