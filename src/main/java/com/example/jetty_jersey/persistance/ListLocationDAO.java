package persistance;

import com.example.jetty_jersey.ws.ListLocation.ListLocationClass;;

interface ListLocationDAO {
	ListLocationClass getListLocation();
	void addListLocation(ListLocationClass instance);
	void editListLocation(int id, ListLocationClass instance);
	void deleteListLocation(ListLocationClass instance);
}
