package persistance;

import com.example.jetty_jersey.ws.ListLocation;

interface ListLocationDAO {
	ListLocation getListLocation();
	void addListLocation(ListLocation instance);
	void editListLocation(int id, ListLocation instance);
	void deleteListLocation(ListLocation instance);
}
