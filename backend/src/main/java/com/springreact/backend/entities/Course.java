package com.springreact.backend.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;


@Entity
@Table(name = "Courses")
@EntityListeners(AuditingEntityListener.class)
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseId;
	@NotBlank
	private String courseTitle;
	@NotBlank
	private String courseDescription;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public Course() {
		super();
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", courseDescription="
				+ courseDescription + "]";
	}
	

}
