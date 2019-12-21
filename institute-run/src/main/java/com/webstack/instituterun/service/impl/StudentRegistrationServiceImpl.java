package com.webstack.instituterun.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webstack.instituterun.dto.BatchDTO;
import com.webstack.instituterun.dto.StudentDTO;
import com.webstack.instituterun.entity.Batch;
import com.webstack.instituterun.entity.Student;
import com.webstack.instituterun.mapper.StudentMapper;
import com.webstack.instituterun.repository.BatchRepository;
import com.webstack.instituterun.repository.CourseRepository;
import com.webstack.instituterun.repository.StudentRegistrationRepository;
import com.webstack.instituterun.service.StudentRegistrationService;

@Service
@Transactional
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

	@Autowired
	private StudentMapper studentMapper;

	@Autowired
	private StudentRegistrationRepository studentRegistrationRepository;
	
	@Autowired
	private BatchRepository batchRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@Override
	public List<StudentDTO> list() {
		return studentRegistrationRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());
	}

	@Override
	public StudentDTO save(StudentDTO studentDTO) {
		Student student = null;
		if(studentDTO.getId() != null && studentDTO.getId() > 0) {
			student = studentRegistrationRepository.getOne(studentDTO.getId());			
		}	
		student = studentMapper.toEntity(studentDTO);
		StudentDTO result = studentMapper.toDto(studentRegistrationRepository.save(student));
		
		return result;
	}

	@Override
	public List<StudentDTO> findAllByFeesStatus(String feesStatus) {		
		List<String> criteriaList = new ArrayList<>();
		criteriaList.add(feesStatus);
		return studentRegistrationRepository.findAllByFeesStatusNotIn(criteriaList).stream().map(studentMapper::toDto).collect(Collectors.toList());
	}

	public List<StudentDTO> findAllByCourseCode(String courseCode){		
		return studentRegistrationRepository.findAllByCourse(courseRepository.findByCourseCode(courseCode))
				.stream()
				.filter(predicate -> predicate.getBatch() == null)
				.map(studentMapper::toDto)				
				.collect(Collectors.toList());
	}

	@Override
	public void updateStudentsBatch(Long batchId, List<StudentDTO> students) {
		Long totalBatchFees = 0l;
		Long totalBatchRemainingFees = 0l;
		Long totalBatchReceivedFees = 0l;
		Batch batch = batchRepository.getOne(batchId);
		for(StudentDTO studentDto : students) {
			Student student = studentRegistrationRepository.getOne(studentDto.getId());
			student.setBatch(batch);
			studentRegistrationRepository.save(student);
		}		
	}

	@Override
	public List<StudentDTO> findAllByBatchId(Long batchId) {
		return studentRegistrationRepository.findAllByBatch(batchRepository.getOne(batchId))
				.stream()				
				.map(studentMapper::toDto)				
				.collect(Collectors.toList());
	}	
}
