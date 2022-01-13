package spring.expense.tracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table
@Transactional
public class Expense {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long studentId;
	
	
	@Column
	private String place;
	
	
	@Column
	private String how;
	
	
	@Column
	private String why;
	
	
	@Column
	private Integer amount;
	
	@CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Date createdAt;
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Long getStudentId() {
		return studentId;
	}



	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}



	public String getPlace() {
		return place;
	}



	public void setPlace(String place) {
		this.place = place;
	}



	public String getHow() {
		return how;
	}



	public void setHow(String how) {
		this.how = how;
	}



	public String getWhy() {
		return why;
	}



	public void setWhy(String why) {
		this.why = why;
	}



	public Integer getAmount() {
		return amount;
	}



	public void setAmount(Integer amount) {
		this.amount = amount;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
