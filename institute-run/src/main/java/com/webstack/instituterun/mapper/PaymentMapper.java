package com.webstack.instituterun.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.webstack.instituterun.dto.PaymentDTO;
import com.webstack.instituterun.entity.Payment;

@Mapper(componentModel = "spring", uses = { StudentMapper.class,
		}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMapper extends EntityMapper<PaymentDTO, Payment>{

	@Mapping(source = "student.id", target = "studentId")
	PaymentDTO toDto(Payment payment);

	@Override
	@Mapping(source = "studentId", target = "student")
	Payment toEntity(PaymentDTO paymentDTO);

	default Payment fromId(Long id) {
		if (id == null)
			return null;
		Payment payment = new Payment();
		payment.setId(id);
		return payment;
	}
	
}
