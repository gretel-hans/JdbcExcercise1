package com.hans.jdbcExcercise;

import java.time.LocalDate;

public class Studente {
	private long id;
	private String name;
	private String last_name;
	private GenderType gender;
	private LocalDate birth_date;
	private double avg;
	private double min_vote ;
	private double max_vote ;
	
	
	
	
	
	
	
	
	public Studente(String name, String last_name, GenderType gender, LocalDate birth_date, double avg, double min_vote,
			double max_vote) {
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}


	public Studente(long id, String name, String last_name, GenderType gender, LocalDate birth_date, double avg,
			double min_vote, double max_vote) {
		this.id = id;
		this.name = name;
		this.last_name = last_name;
		this.gender = gender;
		this.birth_date = birth_date;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public GenderType getGender() {
		return gender;
	}
	public void setGender(GenderType gender) {
		this.gender = gender;
	}
	public LocalDate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public double getMin_vote() {
		return min_vote;
	}
	public void setMin_vote(double min_vote) {
		this.min_vote = min_vote;
	}
	public double getMax_vote() {
		return max_vote;
	}
	public void setMax_vote(double max_vote) {
		this.max_vote = max_vote;
	}
	
	
	@Override
	public String toString() {
		return "Studente [id=" + id + ", name=" + name + ", last_name=" + last_name + ", gender=" + gender
				+ ", birth_date=" + birth_date + ", avg=" + avg + ", min_vote=" + min_vote + ", max_vote=" + max_vote
				+ "]";
	}
	
}
