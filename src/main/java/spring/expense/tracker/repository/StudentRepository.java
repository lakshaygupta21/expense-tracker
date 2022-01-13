package spring.expense.tracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.expense.tracker.model.StudentModel;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long>{

}
