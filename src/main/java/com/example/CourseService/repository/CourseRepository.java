package com.example.CourseService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CourseService.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	public Course findByTitle(String title);

}
