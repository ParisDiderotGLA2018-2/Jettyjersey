package persistance;

import com.example.jetty_jersey.ws.*;

interface MessageDAO {
	Message getMessage();
	void addMessage(Message instance);
	void editMessage(int id, Message instance);
	void deleteMessage(Message instance);
}
