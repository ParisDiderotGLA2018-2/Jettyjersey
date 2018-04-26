package persistance;

import com.example.jetty_jersey.ws.ListMap.ListMapClass;

interface ListMapDAO {
	ListMapClass getMyMaps();
	ListMapClass getFriendsMaps();
	ListMapClass getPublicMaps();
	void addListMap(ListMapClass instance);
	void editListMap(int id, ListMapClass instance);
	void deleteListMap(ListMapClass instance);
}
