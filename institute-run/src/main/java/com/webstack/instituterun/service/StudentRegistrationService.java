package com.webstack.instituterun.service;

import java.util.List;

import com.webstack.instituterun.dto.StudentDTO;

public interface StudentRegistrationService {
	public List<StudentDTO> list();
	public StudentDTO save(StudentDTO studentDTO);
	public List<StudentDTO> findAllByFeesStatus(String feesStatus);
	public List<StudentDTO> findAllByCourseCode(String courseCode);
	public List<StudentDTO> findAllByBatchId(Long batchId);
	public void updateStudentsBatch(Long batchId,List<StudentDTO> students);
}
