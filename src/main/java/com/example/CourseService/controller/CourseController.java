package com.example.CourseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseService.model.Course;
import com.example.CourseService.model.Student;
import com.example.CourseService.service.CourseService;


@RestController
public class CourseController {
	@Autowired
	CourseService courseService;
		
	@PostMapping("/course")
	public ResponseEntity<String> saveCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
		 return new ResponseEntity<String>("course is saved successfully", HttpStatus.OK);
	}
	
	@PutMapping("/course")
	public ResponseEntity<String> UpdateCourse(@RequestBody Course course) {
		courseService.saveCourse(course);
		 return new ResponseEntity<String>("course is Updated successfully", HttpStatus.OK);
	}
	
	@GetMapping("/course/{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
		Course course=courseService.getCourseById(id);
		 return new ResponseEntity<Course>(course, HttpStatus.OK);

	}
	
	@GetMapping("/course1/{title}")
	public ResponseEntity<Course> getCourseByTitle(@PathVariable String title) {
		Course course=courseService.getCourseByTitle(title);
		 return new ResponseEntity<Course>(course, HttpStatus.OK);

	}
	
	@GetMapping("/course2")
	public ResponseEntity<List<Course>> getAllCourese() {
	List<Course> courses=courseService.getAllCourses();
	 return new ResponseEntity<List<Course>>(courses, HttpStatus.OK);
		
	}
	@DeleteMapping("/course/{id}")
	public ResponseEntity<String> deleteCourseById(@PathVariable Long id) {
		courseService.deleteCourseById(id);		
		return new ResponseEntity<String>("course is deleted successfully", HttpStatus.OK);
	}


}
