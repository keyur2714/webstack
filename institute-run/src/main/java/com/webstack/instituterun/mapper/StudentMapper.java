package com.webstack.instituterun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.webstack.instituterun.dto.StudentDTO;
import com.webstack.instituterun.entity.Student;

@Mapper(componentModel = "spring", uses = { CourseMapper.class,BatchMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper extends EntityMapper<StudentDTO, Student> {

	@Override
	@Mapping(source = "course.id", target = "courseId")
	@Mapping(source = "course.courseCode", target = "courseCode")
	@Mapping(source = "course.courseName", target = "courseName")
	@Mapping(source = "course.fees", target = "fees")
	@Mapping(source = "batch.id", target = "batchId")
	@Mapping(source = "batch.batchName", target = "batchName")
	@Mapping(source = "batch.batchType", target = "batchType")
	@Mapping(source = "batch.batchTime", target = "batchTime")
	StudentDTO toDto(Student student);

	@Override
	@Mapping(source = "courseId", target = "course")
	@Mapping(source = "batchId", target = "batch")
	Student toEntity(StudentDTO studentDTO);

	default Student fromId(Long id) {
		if (id == null)
			return null;
		Student student = new Student();
		student.setId(id);
		return student;
	}

}
