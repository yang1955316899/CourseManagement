package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.RoomDaoImpl;
import top.jsjkxyjs.entity.Location;
import top.jsjkxyjs.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
	@Override
	public List<Location> getLocation() {
		return new RoomDaoImpl().getAllLocation();
	}

	@Override
	public List<Location> getRoomByLocationId(int locationId) {
		return new RoomDaoImpl().getRoomByLocationId(locationId);
	}
}
