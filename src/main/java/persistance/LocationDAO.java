package persistance;

import com.example.jetty_jersey.ws.Location;

interface LocationDAO {
	Location getLocation();
	void addLocation(Location instance);
	void editLocation(int id, Location instance);
	void deleteLocation(Location instance);
}