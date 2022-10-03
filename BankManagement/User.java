package bankapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class User {
	private String name, email,  phone, gender, passWord, ifsc;
	private byte age;
	private double balance;
	private long acNumber;
	
	
	
	User(String name, String email,String phone,String gender,String passWord,byte age,double balance,String ifsc, long acno){
		this.name=name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.age = age;
		this.passWord = passWord;
		this.balance = balance;
		this.acNumber = acno;
		this.ifsc = ifsc;
		
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
		return ("_________________________________________\n"+"A\\C holder "+ getName() + " Details !!!"+"\n_________________________________________\n"
	+"\nName : " + getName()+"\nEmail : " + getEmail()+"\nA/C number : " + getAcNumber()+"\nIFSC : " + getIfsc()
		+"\nBalance :" + getBalance()+"\n_________________________________________\n");
		
		
	}

}
