package com.safeschoolmanager.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(SchedulePKId.class)
public class Schedule {

	@Id
	@Column(nullable = false, length = 9)
	private String day;
	@Id
	@Column(nullable = false, length = 10)
	private String classId;
	private String shift1;
	private String lecture1;
	private String lecture2;
	private String lecture3;
	private String shift2;
	private String lecture4;
	private String lecture5;
	private String lecture6;
	private String shift3;
	private String lecture7;
	private String lecture8;
	private String lecture9;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School scheduleForSchool;
	@OneToMany(mappedBy = "onlineTaskForSchedule")
	private List<OnlineTask> onlineTaskList = new ArrayList<>();

	public Schedule() {
		System.out.println("In schedule constr");
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getShift1() {
		return shift1;
	}

	public void setShift1(String shift1) {
		this.shift1 = shift1;
	}

	public String getLecture1() {
		return lecture1;
	}

	public void setLecture1(String lecture1) {
		this.lecture1 = lecture1;
	}

	public String getLecture2() {
		return lecture2;
	}

	public void setLecture2(String lecture2) {
		this.lecture2 = lecture2;
	}

	public String getLecture3() {
		return lecture3;
	}

	public void setLecture3(String lecture3) {
		this.lecture3 = lecture3;
	}

	public String getShift2() {
		return shift2;
	}

	public void setShift2(String shift2) {
		this.shift2 = shift2;
	}

	public String getLecture4() {
		return lecture4;
	}

	public void setLecture4(String lecture4) {
		this.lecture4 = lecture4;
	}

	public String getLecture5() {
		return lecture5;
	}

	public void setLecture5(String lecture5) {
		this.lecture5 = lecture5;
	}

	public String getLecture6() {
		return lecture6;
	}

	public void setLecture6(String lecture6) {
		this.lecture6 = lecture6;
	}

	public String getShift3() {
		return shift3;
	}

	public void setShift3(String shift3) {
		this.shift3 = shift3;
	}

	public String getLecture7() {
		return lecture7;
	}

	public void setLecture7(String lecture7) {
		this.lecture7 = lecture7;
	}

	public String getLecture8() {
		return lecture8;
	}

	public void setLecture8(String lecture8) {
		this.lecture8 = lecture8;
	}

	public String getLecture9() {
		return lecture9;
	}

	public void setLecture9(String lecture9) {
		this.lecture9 = lecture9;
	}

	public School getScheduleForSchool() {
		return scheduleForSchool;
	}

	public void setScheduleForSchool(School scheduleForSchool) {
		this.scheduleForSchool = scheduleForSchool;
	}

	public List<OnlineTask> getOnlineTaskList() {
		return onlineTaskList;
	}

	public void setOnlineTaskList(List<OnlineTask> onlineTaskList) {
		this.onlineTaskList = onlineTaskList;
	}

	@Override
	public String toString() {
		return "Schedule [day=" + day + ", classId=" + classId + ", shift1=" + shift1 + ", lecture1=" + lecture1
				+ ", lecture2=" + lecture2 + ", lecture3=" + lecture3 + ", shift2=" + shift2 + ", lecture4=" + lecture4
				+ ", lecture5=" + lecture5 + ", lecture6=" + lecture6 + ", shift3=" + shift3 + ", lecture7=" + lecture7
				+ ", lecture8=" + lecture8 + ", lecture9=" + lecture9 + "]";
	}
}
