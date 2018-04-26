package persistance;

import com.example.jetty_jersey.ws.ListMessage.ListMessageClass;;

interface ListMessageDAO {
	ListMessageClass getListMessage();
	void addListMessage(ListMessageClass instance);
	void editListMessage(int id, ListMessageClass instance);
	void deleteListMessage(ListMessageClass instance);
}