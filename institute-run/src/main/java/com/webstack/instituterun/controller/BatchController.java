package com.webstack.instituterun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.service.BatchService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 360000)
public class BatchController {

	@Autowired
	private BatchService batchService;
	
	@GetMapping("/batches/list")
	public ResponseEntity<List<BatchDTO>> list() {		
		return new ResponseEntity<List<BatchDTO>>(batchService.list(),HttpStatus.OK);
	}
	
	@GetMapping("/batches/list/{id}")
	public ResponseEntity<BatchDTO> get(@PathVariable("id") Long id) {		
		return new ResponseEntity<BatchDTO>(batchService.get(id),HttpStatus.OK);
	}
	
	@PostMapping("/batches/add")
	public ResponseEntity<Void> addBatch(@RequestBody BatchDTO batchDTO) {
		batchService.save(batchDTO);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
		

}
