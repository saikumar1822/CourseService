package com.example.CourseService.exceptions;

public class CourseNotFoundException extends RuntimeException {
	public CourseNotFoundException() {
		super("CourseNotFoundException");
	}

}
