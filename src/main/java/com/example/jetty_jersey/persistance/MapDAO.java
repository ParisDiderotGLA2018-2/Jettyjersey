package persistance;

import com.example.jetty_jersey.ws.Map.MapClass;

interface MapDAO {
	MapClass getMap();
	void addMap(MapClass instance);
	void editMap(int id, MapClass instance);
	void deleteMap(MapClass instance);
}
