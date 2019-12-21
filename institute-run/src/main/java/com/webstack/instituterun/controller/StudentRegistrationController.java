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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.dto.StudentDTO;
import com.webstack.instituterun.service.StudentRegistrationService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",maxAge = 360000)
public class StudentRegistrationController {

	@Autowired
	private StudentRegistrationService studentRegistrationService;

	@GetMapping("/registration/list")
	public ResponseEntity<List<StudentDTO>> list() {
		return new ResponseEntity<List<StudentDTO>>(studentRegistrationService.list(), HttpStatus.OK);
	}

	@GetMapping("/registration/listByFeesStatus/{feesStatus}")
	public ResponseEntity<List<StudentDTO>> listByFeesStatus(@PathVariable String feesStatus) {
		return new ResponseEntity<List<StudentDTO>>(studentRegistrationService.findAllByFeesStatus(feesStatus),
				HttpStatus.OK);
	}
	
	@GetMapping("/registration/listByCourseCode/{courseCode}")
	public ResponseEntity<List<StudentDTO>> listByCourse(@PathVariable String courseCode) {
		return new ResponseEntity<List<StudentDTO>>(studentRegistrationService.findAllByCourseCode(courseCode),
				HttpStatus.OK);
	}
	
	@GetMapping("/registration/listByBatchId/{batchId}")
	public ResponseEntity<List<StudentDTO>> listByBatch(@PathVariable Long batchId) {
		return new ResponseEntity<List<StudentDTO>>(studentRegistrationService.findAllByBatchId(batchId),
				HttpStatus.OK);
	}

	@PostMapping("/registration/add")
	public ResponseEntity<Void> addStudent(@RequestBody StudentDTO studentDTO) {
		studentRegistrationService.save(studentDTO);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("/registration/updateStudentBatch/{batchId}")
	public ResponseEntity<String> updateStudentBatch(@PathVariable Long batchId,@RequestBody List<StudentDTO> studentList) {
		studentRegistrationService.updateStudentsBatch(batchId, studentList);		
		HttpHeaders headers = new HttpHeaders();
		return ResponseEntity.status(HttpStatus.OK)
				.body("Students Batch Allocation Successfully.");
	}
}
