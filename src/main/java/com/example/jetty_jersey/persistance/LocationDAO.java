package persistance;

import com.example.jetty_jersey.ws.Location.LocationClass;

interface LocationDAO {
	LocationClass getLocation();
	void addLocation(LocationClass instance);
	void editLocation(int id, LocationClass instance);
	void deleteLocation(LocationClass instance);
}