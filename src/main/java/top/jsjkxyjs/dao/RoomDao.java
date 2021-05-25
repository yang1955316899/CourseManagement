package top.jsjkxyjs.dao;

import java.util.List;

public interface RoomDao {

	List<String> getRoomByLocationId(int id);

	List<String> getAllLocation();

	int getMaxSizeById(int id);

	List<String> getRoomUseByTime(int locationId, int year, int semester, int day);

	String getRoomByCourseId(String CourseId);
}
