package spring.expense.tracker.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.transaction.Transactional;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table
@Transactional
public class Due {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private Long studentId;
	
	@Column
	private String whom;
	
	@Column
	private Integer amount;
	
	@CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
	
	
	@Column
	private String last_date;

	
	

	public Due() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Due(Long studentId, String whom, Integer amount, String last_date) {
		super();
		this.studentId = studentId;
		this.whom = whom;
		this.amount = amount;
		this.last_date = last_date;
	}


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


	public String getWhom() {
		return whom;
	}


	public void setWhom(String whom) {
		this.whom = whom;
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


	public String getLast_date() {
		return last_date;
	}


	public void setLast_date(String last_date) {
		this.last_date = last_date;
	}
	
	
	
	
	

}
