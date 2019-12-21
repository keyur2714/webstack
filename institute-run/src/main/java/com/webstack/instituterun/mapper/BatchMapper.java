package com.webstack.instituterun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.entity.Batch;

@Mapper(componentModel = "spring", uses = { CourseMapper.class,
		TrainerMapper.class }, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BatchMapper extends EntityMapper<BatchDTO, Batch> {

	@Override
	@Mapping(source = "course.id", target = "courseId")
	@Mapping(source = "course.courseCode", target = "courseCode")
	@Mapping(source = "course.courseName", target = "courseName")
	@Mapping(source = "course.fees", target = "fees")
	@Mapping(source = "trainer.id", target = "trainerId")
	@Mapping(source = "trainer.trainerName", target = "trainerName")
	@Mapping(source = "trainer.trainerMobileNo", target = "trainerMobileNo")
	@Mapping(source = "trainer.trainerEmail", target = "trainerEmail")
	@Mapping(source = "trainer.trainerType", target = "trainerType")
	@Mapping(source = "trainer.compensationType", target = "compensationType")
	@Mapping(source = "trainer.percentage", target = "percentage")
	@Mapping(source = "trainer.fixedPay", target = "fixedPay")	
	BatchDTO toDto(Batch batch);

	@Override
	@Mapping(source = "courseId", target = "course")
	@Mapping(source = "trainerId", target = "trainer")	
	Batch toEntity(BatchDTO batchDTO);

	default Batch fromId(Long id) {
		if (id == null)
			return null;
		Batch batch = new Batch();
		batch.setId(id);
		return batch;
	}

}
