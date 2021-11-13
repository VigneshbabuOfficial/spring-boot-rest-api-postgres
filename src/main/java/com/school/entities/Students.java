package com.school.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
@DynamicInsert
@DynamicUpdate
@SequenceGenerator(allocationSize = 1, name = "students_seq", sequenceName = "students_seq")
public class Students {

	@Id
	@NotNull(message = "id must not be null")
	@Column(name = "id", columnDefinition = "default nextval('students_seq'::regclass)")
	private Long id;

	@NotNull(message = "name must not be null")
	@Column(name = "name")
	private String name;

	@NotNull(message = "dateOfBirth must not be null")
	@Column(name = "date_of_birth")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date dateOfBirth;

	@NotNull(message = "address must not be null")
	@Column(name = "address")
	private String address;

	@NotNull(message = "gender must not be null")
	@Column(name = "gender")
	private String gender;

	@Column(name = "sports")
	private String sports;

	@Column(name = "curriculums")
	private String curriculums;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSports() {
		return sports;
	}

	public void setSports(String sports) {
		this.sports = sports;
	}

	public String getCurriculums() {
		return curriculums;
	}

	public void setCurriculums(String curriculums) {
		this.curriculums = curriculums;
	}

}
