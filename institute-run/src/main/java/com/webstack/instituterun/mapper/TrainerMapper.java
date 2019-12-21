package com.webstack.instituterun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

import com.webstack.instituterun.dto.TrainerDTO;
import com.webstack.instituterun.entity.Trainer;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TrainerMapper extends EntityMapper<TrainerDTO, Trainer> {
	
	@Override
	@Mapping(source = "id", target = "trainerId")	
	TrainerDTO toDto(Trainer trainer);
	
	@Override
	@Mapping(source = "trainerId", target = "id")	
	Trainer toEntity(TrainerDTO trainerDTO);
	
	default Trainer fromId(Long id) {
		if(id == null)
			return null;
		Trainer trainer = new Trainer();
		trainer.setId(id);
		return trainer;
	}
}
