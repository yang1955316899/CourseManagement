package top.jsjkxyjs.service.impl;

import top.jsjkxyjs.dao.impl.RoomDaoImpl;
import top.jsjkxyjs.service.LocationService;

import java.util.List;

public class LocationServiceImpl implements LocationService {
	@Override
	public List<String> getLocation() {
		return new RoomDaoImpl().getAllLocation();
	}
}
