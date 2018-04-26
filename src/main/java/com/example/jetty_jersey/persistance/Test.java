package persistance;

import com.example.jetty_jersey.ws.User;
import com.example.jetty_jersey.ws.User.UserClass;

public class Test {

	public static void main(String [] args){
		insert_user_test();
	//	update_user_test();
	}
	public static void insert_user_test(){
		System.out.println("Test insert user");
		UserDB u = new UserDB();
		UserClass us = new UserClass();
		us.login = "tata";
		us.password = "toto";
		u.addUser(us);
	}
	public static void update_user_test (){
		System.out.println("Test update user");
		UserDB u = new UserDB();
		UserClass us = new UserClass();
		us.login = "tata2";
		us.password = "toto";
		u.editUser(2, us);
	}
	
}
