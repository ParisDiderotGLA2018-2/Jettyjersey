package persistance;

import com.example.jetty_jersey.ws.Map;

interface MapDAO {
	Map getMap();
	void addMap(Map instance);
	void editMap(int id, Map instance);
	void deleteMap(Map instance);
}
