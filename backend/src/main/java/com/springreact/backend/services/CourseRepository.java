package com.springreact.backend.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springreact.backend.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	/*
	 * public List<Course> getCourses(); public Course getCourse(int id); public
	 * Course addCourse(Course course); public void deleteCourse(int id); public
	 * Course updateCourse(int id, Course course);
	 */
}
