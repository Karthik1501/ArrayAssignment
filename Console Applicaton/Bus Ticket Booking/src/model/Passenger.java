package model;

public class Passenger {
	private String name, email, phone, gender,userName, passWord;
	private byte age;
	
	public Passenger(String name,String gender,byte age,String email,String userName,String passWord,String phone){
		this.name = name;
		this.gender = gender;
		this.age =age;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.passWord = passWord;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	public String toString() {
		return ("\n---------------------------"+"\n          Profile       "+
		"\n---------------------------"+
		"\n    Name     :"+getName()+
		"\n    Age      :"+getAge()+
		"\n    Email    :"+getEmail()+
		"\n    Gender   :"+getGender()+
		"\n    Phone    :"+getPhone()+	
		"\n---------------------------");
		
		
		
	}
}
