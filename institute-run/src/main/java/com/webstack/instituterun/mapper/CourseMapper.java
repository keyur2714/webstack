package com.webstack.instituterun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.dto.CourseDTO;
import com.webstack.instituterun.entity.Batch;
import com.webstack.instituterun.entity.Course;

@Component
@Mapper(componentModel = "spring"
, unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface CourseMapper extends EntityMapper<CourseDTO, Course>{
	
	@Mapping(source = "id", target = "courseId")
	@Override
	CourseDTO toDto(Course course);
	
	@Mapping(source = "courseId", target = "id")
	@Override
	Course toEntity(CourseDTO courseDTO);
	
	default Course fromId(Long id) {
		if(id == null)
			return null;
		Course course = new Course();
		course.setId(id);
		return course;
	}
}
