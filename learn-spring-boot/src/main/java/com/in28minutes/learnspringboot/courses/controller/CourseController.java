package com.in28minutes.learnspringboot.courses.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.learnspringboot.courses.bean.Course;
import com.in28minutes.learnspringboot.courses.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	private CourseRepository repository;

	// http://localhost:8080/courses
	@GetMapping("/courses")
	public List<Course> getAllCourses() {
		return repository.findAll();
	}

	// http://localhost:8080/courses/1
	@GetMapping("/courses/1")
	public Course getCourseDetails(@PathVariable long id) {

		Optional<Course> course = repository.findById(id);

		if (course.isEmpty()) {
			throw new RuntimeException("Course not found with id " + id);
		}

		return course.get();
	}

	// GET - Retrieve information (/courses, /courses/1)
	// POST - Create a new resource (/courses)
	// PUT - Update/Replace a resource (/courses/1)
	// DELETE - Delete a resource (/courses/1)

}
