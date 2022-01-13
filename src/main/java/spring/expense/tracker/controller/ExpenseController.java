package spring.expense.tracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import spring.expense.tracker.model.Expense;
import spring.expense.tracker.repository.ExpenseRepository;

@RestController
public class ExpenseController {

	
	@Autowired
	public ExpenseRepository expenseRepository;
	
	
	@GetMapping(value = "/get-expenses/{id}")
	public List<Expense> getAllExpensesOfStudent(@RequestParam("id") Long id){
		return expenseRepository.findAllByStudentId(id);
	}
}
