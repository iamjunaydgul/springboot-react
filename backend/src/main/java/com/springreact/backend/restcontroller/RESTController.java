package com.springreact.backend.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springreact.backend.dao.CourseDAO;
import com.springreact.backend.entities.Course;

@RestController
@RequestMapping
/*
 * do not use className= RestController otherwise get error cause mixing
 * RestController of Spring
 */
public class RESTController {
	@Autowired
	CourseDAO courseDAO;

	/*
	 * as this is just for REST thats why using GET,POST,DELTE,UPDATE annotations
	 * otherwise in MVC we use @RequestMapping(path= "", method= "")
	 */
	/* for getting courses */
	@GetMapping("/courses")
	public List<Course> getCourses() {
		return courseDAO.getCourses();
	}

	/* for getting specific course */
	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> getCourse(@PathVariable(value = "id") Long courseId) {
		Course course = courseDAO.getCourse(courseId);
		if (course == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok().body(course);
		}
	}

	/* for adding new course */
	@PostMapping(path = "/course") // consumes= "application/json" public Course
	public Course addCourse(@RequestBody Course course) {
		return courseDAO.addCourse(course);
	}

	/* for updating course */
	@PutMapping("/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable(value = "id") Long courseId,
			@RequestBody Course courseDetails) {
		Course course = courseDAO.getCourse(courseId);
		if (course == null) {
			return ResponseEntity.notFound().build();
		} else {
			course.setCourseTitle(courseDetails.getCourseTitle());
			course.setCourseDescription(courseDetails.getCourseDescription());
			Course updatedCourse = courseDAO.addCourse(course);
			return ResponseEntity.ok().body(updatedCourse);
		}
	}

	/* for deleting specific course */
	@DeleteMapping("/courses/{id}")
	public ResponseEntity<Course> deleteCourse(@PathVariable(value = "id") Long courseId) {
		Course course = courseDAO.getCourse(courseId);
		if (course == null) {
			return ResponseEntity.notFound().build();
		} else {
			courseDAO.deleteCourse(courseId);
			return ResponseEntity.ok().body(course);
		}
	}
}
