package com.revature.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * This is a class that represents a Java bean for a BATCH table.
 * It provides getters and setters for all properties,
 * and overrides hashCode(), equals(Object obj), and toString().  
 */
@Entity
@Component
@Table(name = "BATCH")
@SequenceGenerator(name = "batch_seq_name", sequenceName = "batch_seq", initialValue = 5, allocationSize = 1)
public class Batch implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "batch_seq_name")
	@Column(name = "id")
	private int id;

	@NotNull
	@Column(name = "name", unique = true)
	private String name;

	@JsonIgnoreProperties
	@NotNull
	@Column(name = "start_date")
	private Date startDate;

	@JsonIgnoreProperties
	@NotNull
	@Column(name = "end_date")
	private Date endDate;

	@NotNull
	@Column(name = "trainer_id")
	private int trainerId;

	@NotNull
	@Column(name = "calendar_curriculum_id")
	private int calendarCurriculumId;

	public Batch() {
		super();
	}

	public Batch(int id, String name, Date startDate, Date endDate, int trainerId, int calendarCurriculumId) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerId = trainerId;
		this.calendarCurriculumId = calendarCurriculumId;
	}

	public Batch(String name, Date startDate, Date endDate, int trainerId, int calendarCurriculumId) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainerId = trainerId;
		this.calendarCurriculumId = calendarCurriculumId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}

	public int getCalendarCurriculumId() {
		return calendarCurriculumId;
	}

	public void setCalendarCurriculumId(int calendarCurriculumId) {
		this.calendarCurriculumId = calendarCurriculumId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calendarCurriculumId;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + trainerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		if (calendarCurriculumId != other.calendarCurriculumId)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (trainerId != other.trainerId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", trainerId=" + trainerId + ", calendarCurriculumId=" + calendarCurriculumId + "]";
	}
}
