package persistance;
import com.example.jetty_jersey.ws.*;

public interface UserDAO {
		User getUser(String name);
		User addUser(User instance);
		void editUser(int id, User instance);
		void deleteUser(User instance);
}
