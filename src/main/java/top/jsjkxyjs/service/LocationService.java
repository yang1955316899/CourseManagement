package top.jsjkxyjs.service;

import top.jsjkxyjs.entity.Location;

import java.util.List;

public interface LocationService {
	List<Location> getLocation();

	List<Location> getRoomByLocationId(int locationId);

	int getmaxSizeById(int roomId);
}
