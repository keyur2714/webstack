package com.webstack.instituterun.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.dto.PaymentDTO;
import com.webstack.instituterun.entity.Payment;
import com.webstack.instituterun.entity.Student;
import com.webstack.instituterun.mapper.PaymentMapper;
import com.webstack.instituterun.repository.PaymentRepository;
import com.webstack.instituterun.repository.StudentRegistrationRepository;
import com.webstack.instituterun.service.PaymentService;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentMapper paymentMapper;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;

	public PaymentDTO save(PaymentDTO paymentDTO) {

		if (paymentDTO.getStudentId() != null && paymentDTO.getStudentId() > 0) {
			Student student = studentRegistrationRepository.getOne(paymentDTO.getStudentId());
			student.setFeesPaid(student.getFeesPaid() + paymentDTO.getPaymentReceived());
			student.setFeesRemaining(student.getFinalFees() - student.getFeesPaid());
			if (student.getFeesRemaining() == 0) {
				student.setFeesStatus("PAID");
			} else if (student.getFeesRemaining() != 0) {
				student.setFeesStatus("HALF_PAID");
			} else {
				student.setFeesStatus("NOT_PAID");
			}
			studentRegistrationRepository.save(student);
			Payment payment = paymentMapper.toEntity(paymentDTO);
			PaymentDTO result = paymentMapper.toDto(paymentRepository.save(payment));
			return result;
		}
		return null;

	}

	public List<PaymentDTO> list() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll().stream().map(paymentMapper::toDto).collect(Collectors.toList());
	}

	public BatchDTO get(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
