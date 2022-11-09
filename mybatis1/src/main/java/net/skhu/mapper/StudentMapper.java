package net.skhu.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import net.skhu.dto.Student;

@Mapper
public interface StudentMapper {
	@Select("SELECT s.*, d.name departmentName FROM student s JOIN department d ON s.departmentId = d.id")
	List<Student> findAll();

	@Select("SELECT s.*, d.name departmentName FROM student s LEFT JOIN department d ON s.departmentId = d.id "
			+ "WHERE s.name LIKE #{name}")
	List<Student> findByName(String name);
}
