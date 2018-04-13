package persistance;

import com.example.jetty_jersey.ws.Message.MessageClass;

interface MessageDAO {
	MessageClass getMessage();
	void addMessage(MessageClass instance);
	void editMessage(int id, MessageClass instance);
	void deleteMessage(MessageClass instance);
}
