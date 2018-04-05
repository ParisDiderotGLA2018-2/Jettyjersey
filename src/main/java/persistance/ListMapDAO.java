package persistance;

import com.example.jetty_jersey.ws.ListMap;

interface ListMapDAO {
	ListMap getMyMaps();
	ListMap getFriendsMaps();
	ListMap getPublicMaps();
	void addListMap(ListMap instance);
	void editListMap(int id, ListMap instance);
	void deleteListMap(ListMap instance);
}
