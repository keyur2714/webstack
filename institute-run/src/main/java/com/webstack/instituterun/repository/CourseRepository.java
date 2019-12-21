package com.webstack.instituterun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webstack.instituterun.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
	Course findByCourseCode(String courseCode);
}
