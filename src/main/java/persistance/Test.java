package persistance;

import com.example.jetty_jersey.ws.User;

public class Test {

	public static void main(String [] args){
		insert_user_test();
	//	update_user_test();
	}
	public static void insert_user_test(){
		System.out.println("Test insert user");
		UserDB u = new UserDB();
		u.addUser(new User("tata","toto"));
	}
	public static void update_user_test (){
		System.out.println("Test update user");
		UserDB u = new UserDB();
		u.editUser(2, new User("tata2","toto"));
	}
	
}
