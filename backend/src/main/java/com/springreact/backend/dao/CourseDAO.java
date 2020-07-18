package com.springreact.backend.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springreact.backend.entities.Course;
import com.springreact.backend.services.CourseRepository;

@Service
public class CourseDAO {
	@Autowired
	CourseRepository cs;

	/* method to get courses */
	public List<Course> getCourses() {
		return cs.findAll();
	}

	/* method to get course */
	public Course getCourse(long courseId) {
		return cs.findById(courseId).orElse(null);
	}

	/* method to add course */
	public Course addCourse(Course course) {
		cs.save(course);
		return course;
	}
	/* method to update courses */
	public Course updateCourse(long courseId, Course courseDetails) {
		Course course = cs.findById(courseId).orElse(null);
		if (course == null) {
			return null;
		} else {
			course.setCourseId(courseDetails.getCourseId());
			course.setCourseTitle(courseDetails.getCourseTitle());
			course.setCourseDescription(courseDetails.getCourseDescription());
			Course updatedCourse = cs.save(course);
			return updatedCourse;
		}
	}
	/* method to delete courses */
	public void deleteCourse(long courseId) {
		cs.deleteById(courseId);;
	}

}
