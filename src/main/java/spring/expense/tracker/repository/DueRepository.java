package spring.expense.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import spring.expense.tracker.model.Due;
import spring.expense.tracker.model.Expense;

@Repository
public interface DueRepository extends JpaRepository<Due, Long>{
	
	@Query(value = "select * from due where student_id = :studentId and amount > 0 order by created_at ASC", nativeQuery = true)
	public List<Due>findAllByStudentIdOrderByCreatedAtAsc(Long studentId);
	
	@Query(value = "select * from due where student_id = :studentId and amount > 0 order by created_at DESC", nativeQuery = true)
	public List<Due>findAllByStudentIdOrderByCreatedAtDesc(Long studentId);
	
	@Query(value = "select * from due where student_id = :studentId and amount > 0", nativeQuery = true)
	public List<Due>findAllByStudentId(Long studentId);
}
