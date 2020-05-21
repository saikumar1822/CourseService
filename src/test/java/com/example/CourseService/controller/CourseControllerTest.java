package com.example.CourseService.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.example.CourseService.model.Course;
import com.example.CourseService.model.Student;
import com.example.CourseService.service.CourseService;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseControllerTest {
	@InjectMocks
	CourseController courseController;

	@Mock
	CourseService courseService;

	@Test
	public void testSaveCourseForPositive() {
		Course course = new Course();
		course.setId(12l);
		course.setTitle("SpringBoot");
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		students.add(student);
		course.setStudents(students);
		Mockito.when( courseService.saveCourse(Mockito.any(Course.class))).thenReturn((course));
		ResponseEntity<String> resCourse = courseController.saveCourse(course);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(),"SpringBoot");
	}

	@Test
	public void testSaveCourseForNegative() {
		Course course1 = new Course();
		course1.setId(12l);
		course1.setTitle("Spring");
		Course course = new Course();
		course.setId(122l);
		course.setTitle("Spring");
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		students.add(student);
		course.setStudents(students);
		Mockito.when(courseService.saveCourse(Mockito.any(Course.class))).thenReturn((course1));
		ResponseEntity<String> resCourse = courseController.saveCourse(course);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(),"Spring");
	}

	@Test(expected =Exception.class)
	public void testSavCourseForExce() {
		Course course = new Course();
		Mockito.when(courseService.saveCourse(Mockito.any(Course.class))).thenThrow(Exception.class);
		ResponseEntity<String> resStudent = courseController.saveCourse(course);
	}

	@Test
	public void testgetCourseByIdForPositive() {
		Course course = new Course();
		course.setId(1l);
		course.setTitle("Spring");
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		students.add(student);
		course.setStudents(students);
		Mockito.when(courseService.getCourseById(Mockito.anyLong())).thenReturn(course);
		ResponseEntity<Course> resCourse = courseController.getCourseById(1l);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(),"Spring");
	}

	@Test(expected = Exception.class)
	public void testFindByIdForExce() {
		Course course = new Course();
		course.setId(2l);
		Mockito.when(courseService.getCourseById(1l)).thenThrow(Exception.class);
		ResponseEntity<Course> resCourse = courseController.getCourseById(1l);
	}
	
	@Test
	public void testgetCourseByTitleForPositive() {
		Course course = new Course();
		course.setId(1l);
		course.setTitle("Spring");
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		students.add(student);
		course.setStudents(students);
		Mockito.when(courseService.getCourseByTitle(Mockito.anyString())).thenReturn(course);
		ResponseEntity<Course> resCourse = courseController.getCourseByTitle("Spring");
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(),"Spring");
	}

	@Test(expected = Exception.class)
	public void testgetCourseByTitleExce() {
		Course course = new Course();
		course.setId(2l);
		Mockito.when(courseService.getCourseByTitle("Spring")).thenThrow(Exception.class);
		Course resCourse = courseService.getCourseByTitle("Springboot");
	}



	@Test
	public void testGetAllCoursesForPosite() {
		Course course1 = new Course();
		course1.setId(12l);
		Course course = new Course();
		course1.setId(13l);
		List<Course> courses = new ArrayList();
		courses.add(course1);
		courses.add(course);
		Mockito.when(courseService.getAllCourses()).thenReturn(courses);
		ResponseEntity<List<Course>> resCourses = courseController.getAllCourese();
		Assert.assertNotNull(resCourses);
		Assert.assertEquals(2, courses.size());

	}

	@Test(expected = Exception.class)
	public void testGetAllCoursesForExc() {
		Mockito.when(courseService.getAllCourses()).thenThrow(Exception.class);
		ResponseEntity<List<Course>> resCourses = courseController.getAllCourese();
	}


	

}
