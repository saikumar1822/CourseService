package com.example.CourseService.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.CourseService.exceptions.CourseNotFoundException;
import com.example.CourseService.exceptions.NoCourseFoundException;
import com.example.CourseService.exceptions.NullDataFOundInCourseException;
import com.example.CourseService.model.Course;
import com.example.CourseService.model.Student;
import com.example.CourseService.repository.CourseRepository;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.Silent.class)
public class CourseServiceTest {
	@InjectMocks
	CourseService courseService;

	@Mock
	CourseRepository courseRepository;

	@Test
	public void testSaveCourseForPositive() {
		Course course = new Course();
		course.setId(12l);
		course.setTitle("Spring");
		List<Student> students = new ArrayList();
		Student student = new Student();
		student.setName("sai");
		student.setId(1l);
		student.setEmail("sai@gmail.com");
		students.add(student);
		course.setStudents(students);
		Mockito.when(courseRepository.save(Mockito.any(Course.class))).thenReturn((course));
		Course resCourse = courseService.saveCourse(course);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(), resCourse.getTitle());
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
		Mockito.when(courseRepository.save(Mockito.any(Course.class))).thenReturn((course1));
		Course resCourse = courseService.saveCourse(course);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(), resCourse.getTitle());
	}

	@Test(expected = NullDataFOundInCourseException.class)
	public void testSavCourseForExce() {
		Course course = new Course();
		Mockito.when(courseRepository.save(Mockito.any(Course.class))).thenThrow(NullDataFOundInCourseException.class);
		Course resStudent = courseService.saveCourse(course);
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
		Mockito.when(courseRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(course));
		Course resCourse = courseService.getCourseById(1l);
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(), resCourse.getTitle());
	}

	@Test(expected = CourseNotFoundException.class)
	public void testFindByIdForExce() {
		Course course = new Course();
		course.setId(2l);
		Mockito.when(courseRepository.findById(2l)).thenReturn(Optional.of(course));
		Course resCourse = courseService.getCourseById(1l);
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
		Mockito.when(courseRepository.findByTitle(Mockito.anyString())).thenReturn(course);
		Course resCourse = courseService.getCourseByTitle("Spring");
		Assert.assertNotNull(resCourse);
		Assert.assertEquals(course.getTitle(), resCourse.getTitle());
	}

	@Test(expected = CourseNotFoundException.class)
	public void testgetCourseByTitleExce() {
		Course course = new Course();
		course.setId(2l);
		Mockito.when(courseRepository.findByTitle("Spring")).thenReturn(course);
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
		Mockito.when(courseRepository.findAll()).thenReturn(courses);
		List<Course> resCourses = courseService.getAllCourses();
		Assert.assertNotNull(resCourses);
		Assert.assertEquals(resCourses.size(), courses.size());

	}

	@Test(expected = NoCourseFoundException.class)
	public void testGetAllCoursesForExc() {
		Mockito.when(courseRepository.findAll()).thenThrow(NoCourseFoundException.class);
		List<Course> resCourses = courseService.getAllCourses();
	}

}
