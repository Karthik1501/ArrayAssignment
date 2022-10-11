package controller;

import java.util.HashMap;

import model.Passenger;

public class UserData {
   static HashMap<String, Passenger> users = new HashMap<>();
   
   public UserData(String name,String gender,byte age,String email,String userName,String passWord,String phone){
	   users.put(userName,new Passenger(name, gender, age, email, userName, passWord, phone));
   }
   
   UserData(){	   
   }
}
