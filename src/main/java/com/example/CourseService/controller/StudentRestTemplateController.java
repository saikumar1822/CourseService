package com.example.CourseService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CourseService.model.Student;
import com.example.CourseService.service.StudentRestTemplateService;

@RestController
public class StudentRestTemplateController {
	
	@Autowired
	StudentRestTemplateService studentRestTemplateService;
	
	@GetMapping("students")
	public String getAllStudents() {
		 return  studentRestTemplateService.getAllStudents();
	}
	@GetMapping("student/{id}")
	public String getStudentByPathVar(@PathVariable String id) {
		 return  studentRestTemplateService.getStudentByPathVar(id);
	}
	
	@GetMapping("student1")
	public String getStudentByRequestParam(@RequestParam String name) {
		 return  studentRestTemplateService.getStudentsByReqParam(name);
	}
	@PostMapping("student")
    public ResponseEntity<String> SaveStudentByPostBody(@RequestBody Student student) {
    	return studentRestTemplateService.SaveStudentByPostBody(student);
    }
	

}
