package persistance;
import com.example.jetty_jersey.ws.*;
import com.example.jetty_jersey.ws.User.UserClass;

public interface UserDAO {
		UserClass getUser(String name);
		UserClass addUser(UserClass instance);
		void editUser(int id, UserClass instance);
		void deleteUser(UserClass instance);
}
