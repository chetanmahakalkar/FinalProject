package com.safeschoolmanager.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(ClassroomPKId.class)
public class Classroom {
	@Id
	@Column(nullable = false, length = 5)
	private String classroom;
	@Id
	@Column(nullable = false, length = 3)
	private String section;

	@OneToOne(mappedBy = "class_teacher")
	private Teacher classTeacher;

	@Override
	public String toString() {
		return "Classroom [classroom=" + classroom + ", Section=" + section + "," + "classTeacher=" + classTeacher
				+ "]";
	}

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
}
