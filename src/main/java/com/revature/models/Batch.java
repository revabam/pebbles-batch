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


@Entity
@Component
@Table(name="BATCH")
@SequenceGenerator(name="batch_seq_name", sequenceName="batch_seq", initialValue=5, allocationSize=1)
public class Batch implements Serializable{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="batch_seq_name")
	@Column(name="id")
	private Integer id;
	
	@NotNull
	@Column(name="name", unique=true)
	private String name;
	
	@JsonIgnoreProperties
	@NotNull
	@Column(name="start_date")
	private Date startDate;
		
	@JsonIgnoreProperties
	@NotNull
	@Column(name="end_date")
	private Date endDate;
	
	@NotNull
	@Column(name="trainer_id")
	private int trainer_id; 
	
	@NotNull
	@Column(name="calendar_curriculum_id")
	private int calendarCurriculum_id;
	
	public Batch() {
		super();
	}	
	

	public Batch(Integer id, @NotNull String name, @NotNull Date startDate, @NotNull Date endDate,
			@NotNull int trainer_id, @NotNull int calendarCurriculum_id) {
		super();
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainer_id = trainer_id;
		this.calendarCurriculum_id = calendarCurriculum_id;
	}


	public Batch(@NotNull String name, @NotNull Date startDate, @NotNull Date endDate, @NotNull int trainer_id,
			@NotNull int calendarCurriculum_id) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.trainer_id = trainer_id;
		this.calendarCurriculum_id = calendarCurriculum_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public int getCalendarCurriculum_id() {
		return calendarCurriculum_id;
	}

	public void setCalendarCurriculum_id(int calendarCurriculum_id) {
		this.calendarCurriculum_id = calendarCurriculum_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + calendarCurriculum_id;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + trainer_id;
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
		if (calendarCurriculum_id != other.calendarCurriculum_id)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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
		if (trainer_id != other.trainer_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", trainer_id=" + trainer_id + ", calendarCurriculum_id=" + calendarCurriculum_id + "]";
	}

}
