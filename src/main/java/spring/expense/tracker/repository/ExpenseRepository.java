package spring.expense.tracker.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.expense.tracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long>{
public List<Expense>findAllByStudentId(Long studentId);
}
