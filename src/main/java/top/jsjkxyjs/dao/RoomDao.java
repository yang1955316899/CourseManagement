package top.jsjkxyjs.dao;

import top.jsjkxyjs.entity.Location;

import java.util.List;

public interface RoomDao {

	List<Location> getRoomByLocationId(int locationId);

	List<Location> getAllLocation();

	int getMaxSizeById(int id);

	List<String> getRoomUseByTime(int locationId, int year, int semester, int day);

	String getRoomByCourseId(String CourseId);
}
