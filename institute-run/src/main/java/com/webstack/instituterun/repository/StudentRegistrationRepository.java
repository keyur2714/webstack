package com.webstack.instituterun.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstack.instituterun.entity.Batch;
import com.webstack.instituterun.entity.Course;
import com.webstack.instituterun.entity.Student;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<Student, Long>{
	List<Student> findAllByFeesStatusNotIn(List criteriaList);
	List<Student> findAllByCourse(Course course);
	List<Student> findAllByBatch(Batch batch);
}
