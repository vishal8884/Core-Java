package Collections.map;

import java.util.HashMap;
import java.util.Map;

public class Location {

	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;

	public Location(int locationId, String description) {
		this.locationId = locationId;
		this.description = description;
		this.exits = null;
	}

	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<>(exits);
	}
	
    public void addExit(String direction, int location) {
    	exits.put(direction, location);
    }
	
}
