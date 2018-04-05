package persistance;

import com.example.jetty_jersey.ws.ListMessage;

interface ListMessageDAO {
	ListMessage getListMessage();
	void addListMessage(ListMessage instance);
	void editListMessage(int id, ListMessage instance);
	void deleteListMessage(ListMessage instance);
}