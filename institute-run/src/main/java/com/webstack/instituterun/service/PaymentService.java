package com.webstack.instituterun.service;

import java.util.List;

import com.webstack.instituterun.dto.PaymentDTO;

public interface PaymentService {
	public PaymentDTO save(PaymentDTO paymentDTO);
	public List<PaymentDTO> list();
}
