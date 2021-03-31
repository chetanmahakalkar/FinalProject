package com.safeschoolmanager.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OnlineTask {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, length = 5)
	private Integer onlineTaskId;
	@Column(nullable = false)
	private String taskDescription;
	private String SubmissionLink;
	@Column(nullable = false, length = 10)
	private LocalDate dueDate;
	@ManyToOne
	@JoinColumns({ @JoinColumn(name = "schedule_onlineTask_day", referencedColumnName = "day"),
			@JoinColumn(name = "schedule_onlineTask_classId", referencedColumnName = "classId")

	})
	private Schedule onlineTaskForSchedule;

	public Integer getOnlineTaskId() {
		return onlineTaskId;
	}

	public void setOnlineTaskId(Integer onlineTaskId) {
		this.onlineTaskId = onlineTaskId;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getSubmissionLink() {
		return SubmissionLink;
	}

	public void setSubmissionLink(String submissionLink) {
		SubmissionLink = submissionLink;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Schedule getOnlineTaskForSchedule() {
		return onlineTaskForSchedule;
	}

	public void setOnlineTaskForSchedule(Schedule onlineTaskForSchedule) {
		this.onlineTaskForSchedule = onlineTaskForSchedule;
	}

}
