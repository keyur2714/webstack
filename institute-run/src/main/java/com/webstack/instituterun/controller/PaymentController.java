package com.webstack.instituterun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.instituterun.dto.PaymentDTO;
import com.webstack.instituterun.service.PaymentService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 360000)
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/payments/list")
	public ResponseEntity<List<PaymentDTO>> list() {		
		return new ResponseEntity<List<PaymentDTO>>(paymentService.list(),HttpStatus.OK);
	}
	
	@PostMapping("/payments/add")
	public ResponseEntity<Void> addPayment(@RequestBody PaymentDTO paymentDTO) {
		paymentService.save(paymentDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

}
